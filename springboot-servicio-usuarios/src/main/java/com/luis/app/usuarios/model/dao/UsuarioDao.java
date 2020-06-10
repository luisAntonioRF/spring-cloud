package com.luis.app.usuarios.model.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.luis.app.usuarios.model.entity.Usuario;

@RepositoryRestResource(path = "usuarios")
public interface UsuarioDao extends PagingAndSortingRepository<Usuario,Long> {
	
	//modeo1
	@RestResource(path="busca-user")
	public Usuario findByUsername(String username);
	
	//modo2
	@Query(value = "select u from Usuario u where u.username=?1")
	public Usuario getByUsername(String username);
}
