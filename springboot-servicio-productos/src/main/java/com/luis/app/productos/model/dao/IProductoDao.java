package com.luis.app.productos.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.luis.app.commons.model.*;

public interface IProductoDao extends CrudRepository<Producto,Long> {

}
