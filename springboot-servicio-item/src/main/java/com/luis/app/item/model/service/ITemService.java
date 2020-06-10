package com.luis.app.item.model.service;

import java.util.List;

import com.luis.app.item.model.Item;
import com.luis.app.commons.model.*;

public interface ITemService {
	
	public List<Item> findAll();
	
	public Item findById(Long id,Integer cantidad);
	
	public Producto saveProducto(Producto producto);
	
	public Producto updateProducto(Producto producto, Long id);
	
	public void deleteProducto(Long id);
}
