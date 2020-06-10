package com.luis.app.oaut.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luis.app.usuarios.model.entity.Usuario;

@FeignClient(name = "servicio-usuarios")
public interface UsuarioFeignClient {
	
	@GetMapping("/usuarios/search/busca-user")
	public Usuario findByUsername(@RequestParam String username);

}
