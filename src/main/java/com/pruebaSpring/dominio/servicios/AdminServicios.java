package com.pruebaSpring.dominio.servicios;

import com.pruebaSpring.dominio.entidades.Producto;

public interface AdminServicios extends UsuarioServicios {
	
	Producto save(Producto producto);
	Producto update(Producto objet);
	void delete(Long id);
}
