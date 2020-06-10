package com.luis.app.item.model.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luis.app.commons.model.Producto;
import com.luis.app.item.clientes.IProductoClienteRest;
import com.luis.app.item.model.Item;

@Service
public class ItemServiceFeignImpl implements ITemService {

	@Autowired
	IProductoClienteRest clienteFeign;
	
	@Override
	public List<Item> findAll() {
		return clienteFeign.listar().stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		return new Item(clienteFeign.detalle(id), cantidad);
	}

	@Override
	public Producto saveProducto(Producto producto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto updateProducto(Producto producto, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProducto(Long id) {
		// TODO Auto-generated method stub
		
	}

}
