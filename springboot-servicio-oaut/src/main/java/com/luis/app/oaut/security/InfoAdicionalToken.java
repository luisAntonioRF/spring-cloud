package com.luis.app.oaut.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.luis.app.oaut.service.IUsuarioService;
import com.luis.app.usuarios.model.entity.Usuario;

@Component
public class InfoAdicionalToken  implements TokenEnhancer{

	@Autowired
	IUsuarioService usuarioService;
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Map<String, Object> info = new HashMap<String, Object>();
		Usuario user =  usuarioService.findByUsername(authentication.getName());
		info.put("nombre",user.getNombre());
		info.put("apellido",user.getApellido());
		info.put("email", user.getEmail());
		((DefaultOAuth2AccessToken)  accessToken).setAdditionalInformation(info);
		return accessToken;
	}

}
