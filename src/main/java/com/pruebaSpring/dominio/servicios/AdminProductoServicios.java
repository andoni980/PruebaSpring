package com.pruebaSpring.dominio.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pruebaSpring.datos.ProductoRepository;
import com.pruebaSpring.dominio.entidades.Producto;

@Component
public class AdminProductoServicios extends UsuarioProductoServicios implements AdminServicios {
	
	@Autowired
	ProductoRepository productoRepository;
	
	@Override
	public void delete(Long id) {
		productoRepository.deleteById(id);
	}

	@Override
	public Producto save(Producto producto) {
		return productoRepository.save(producto);
	}

	@Override
	public Producto update(Producto producto) {
		// TODO Auto-generated method stub
		return null;
	}

}
