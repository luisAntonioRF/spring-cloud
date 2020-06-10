package com.luis.app.oaut.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.luis.app.oaut.client.UsuarioFeignClient;
import com.luis.app.usuarios.model.entity.Usuario;

@Service
public class UserService implements IUsuarioService,UserDetailsService {

	private static final Logger log = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	UsuarioFeignClient feignClient;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = feignClient.findByUsername(username);
		
		if(usuario == null) {
			log.error("No Existe"+username);
			throw new UsernameNotFoundException("No Existe el usuario");
		}
		
		List<GrantedAuthority> authorities = usuario.getRoles().stream()
				                                             .map(role -> new SimpleGrantedAuthority(role.getName()))
				                                             .peek(authority -> log.info("Role:"+authority.getAuthority()))
				                                             .collect(Collectors.toList());
	
		
		return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true, authorities);
	}

	@Override
	public Usuario findByUsername(String username) {
		return  feignClient.findByUsername(username);
	}

}
