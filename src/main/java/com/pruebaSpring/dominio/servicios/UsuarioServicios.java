package com.pruebaSpring.dominio.servicios;

import java.util.List;
import java.util.Optional;

import com.pruebaSpring.dominio.entidades.Producto;
import com.pruebaSpring.dominio.entidades.Usuario;

public interface UsuarioServicios {

	List<Producto> getAllProductos();
	
	Optional<Producto> getProductoById(Long id);

	List<Producto> getProductoByCategoria(Long idCategoria);

	Optional<List<Producto>> getScarceProductos(int cantidad);
	
	Optional<List<Producto>> getProductoByPartialName(String name);
	
	Usuario login(String email, String password);
	
}
