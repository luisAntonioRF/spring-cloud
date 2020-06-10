package com.luis.app.productos.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luis.app.productos.model.dao.IProductoDao;
import com.luis.app.commons.model.Producto;

@Service
public class ProductoServiceImpl implements IProductoService{
	
	@Autowired
	IProductoDao IproductoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		return (List<Producto>)IproductoDao.findAll();
	}

	@Override
	public Producto findById(Long id) {
		return IproductoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Producto save(Producto producto) {
		return IproductoDao.save(producto);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		IproductoDao.deleteById(id);
	}

}
