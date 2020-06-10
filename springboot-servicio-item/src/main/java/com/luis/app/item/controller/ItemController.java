package com.luis.app.item.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.luis.app.item.model.Item;
import com.luis.app.commons.model.*;
import com.luis.app.item.model.service.ITemService;

@RestController
public class ItemController {
	
	@Autowired
	@Qualifier("restTemplate")
	ITemService IServiceItem;
	
	@Autowired
	private Environment env;
	
	@Value("${configuracion.texto}")
	private String txt;
	
	@GetMapping("/listar")
	public List<Item> listarItem(){
		return IServiceItem.findAll();
	}
	
	@GetMapping("/ver/{id}/cantidad/{cantidad}")
	public Item detalle(@PathVariable Long id,@PathVariable Integer cantidad) {
		return IServiceItem.findById(id, cantidad);
	}
	
	@GetMapping("/obtenerConfig")
	public ResponseEntity<?> obtenerConfig(){
		Map<String,String> map = new HashMap<String, String>();
		map.put("txt",txt);
		
		if(env.getActiveProfiles().length > 0 && env.getActiveProfiles()[0].equals("dev")) {
			map.put("autor.nombre", env.getProperty("configuracion.autor.nombre"));
			map.put("autor.email", env.getProperty("configuracion.autor.email"));
		}
		return new ResponseEntity<Map<String,String>>(map,HttpStatus.OK);
	}
	
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto crearProducto(@RequestBody Producto producto) {
		return IServiceItem.saveProducto(producto);
	}
	

	@PutMapping("/editar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto editar(@RequestBody Producto producto,@PathVariable Long id) {
		return IServiceItem.updateProducto(producto, id);
	}
	
	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Long id) {
		IServiceItem.deleteProducto(id);
	}
}
