package com.luis.app.productos.model.service;

import java.util.List;

import com.luis.app.commons.model.Producto;

public interface IProductoService {
	
	public List<Producto> findAll();
	
	public Producto findById(Long id);
	
	public Producto save(Producto producto);
	
	public void deleteById(Long id);
}
