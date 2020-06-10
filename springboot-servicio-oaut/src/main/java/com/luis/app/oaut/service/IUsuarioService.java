package com.luis.app.oaut.service;

import com.luis.app.usuarios.model.entity.Usuario;

public interface IUsuarioService {
	
	public Usuario findByUsername(String username);
}
