package com.luis.app.item.model.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.luis.app.item.model.Item;
import com.luis.app.commons.model.*;

@Service("restTemplate")
public class ITemServiceImpl implements ITemService {

	@Autowired
	RestTemplate clienteRest;
	
	@Override
	public List<Item> findAll() {
		List<Producto> productos = Arrays.asList(clienteRest.getForObject("http://servicio-productos/listar",Producto[].class));
		return productos.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		Map<String,String> PathVariable = new HashMap<String,String>();
		PathVariable.put("id",id.toString());
		
		Producto producto = clienteRest.getForObject("http://servicio-productos/ver/{id}",Producto.class,PathVariable);
		return new Item(producto, cantidad);
	}

	@Override
	public Producto saveProducto(Producto producto) {
		HttpEntity<Producto>requestEntity = new HttpEntity<Producto>(producto);
		ResponseEntity<Producto>responseProducto = clienteRest.exchange("http://servicio-productos/crear",HttpMethod.POST, requestEntity, Producto.class);
		Producto response = responseProducto.getBody();
		return response;
	}

	@Override
	public Producto updateProducto(Producto producto, Long id) {
		Map<String,String> PathVariable = new HashMap<String,String>();
		PathVariable.put("id",id.toString());
		HttpEntity<Producto>requestEntity = new HttpEntity<Producto>(producto);
		HttpEntity<Producto> response = clienteRest.exchange("http://servicio-productos/editar/{id}", HttpMethod.PUT, requestEntity, Producto.class,PathVariable);
		return response.getBody();
	}

	@Override
	public void deleteProducto(Long id) {
		Map<String,String> PathVariable = new HashMap<String,String>();
		PathVariable.put("id",id.toString());
		clienteRest.delete("http://servicio-productos/delete/{id}", PathVariable);
	}

}
