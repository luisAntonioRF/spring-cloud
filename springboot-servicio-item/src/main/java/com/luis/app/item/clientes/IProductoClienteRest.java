package com.luis.app.item.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.luis.app.commons.model.*;

@FeignClient(name = "servicio-productos",url = "localhost:8001")
public interface IProductoClienteRest {
	
	@GetMapping("/listar")
	public List<Producto>listar();
	
	@GetMapping("/ver/{id}")
	public Producto detalle(@PathVariable Long id);
}
