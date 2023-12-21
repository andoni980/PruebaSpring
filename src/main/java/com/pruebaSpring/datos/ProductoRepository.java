package com.pruebaSpring.datos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.pruebaSpring.dominio.entidades.Producto;

public class ProductoRepository {
	
	@Autowired
	private ProductoCrudRepository productoCrudRepository;
	
	public List<Producto> getAllProductos(){
		return (List<Producto>)productoCrudRepository.findAll();
	}
	
	public List<Producto> getByCategoria(Long idCategoria){
		return (List<Producto>)productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
	}
	
	public Optional<List<Producto>> getScarce(int cantidad){
		return (Optional<List<Producto>>)productoCrudRepository.findByStockLessThanAndEstado(cantidad, true);
	}

}
