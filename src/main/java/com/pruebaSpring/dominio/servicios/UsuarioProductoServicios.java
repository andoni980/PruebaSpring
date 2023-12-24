package com.pruebaSpring.dominio.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.pruebaSpring.datos.CategoriaRepository;
import com.pruebaSpring.datos.ProductoRepository;
import com.pruebaSpring.dominio.entidades.Categoria;
import com.pruebaSpring.dominio.entidades.Producto;
import com.pruebaSpring.dominio.entidades.Usuario;

@Component
@Primary
public class UsuarioProductoServicios implements UsuarioServicios{

	@Autowired
	ProductoRepository productoRepository;
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	public List<Producto> getAllProductos(){
		return (List<Producto>) productoRepository.findAll();
	}
	
	@Override
	public Optional<Producto> getProductoById(Long id) {
		return productoRepository.findById(id);
	}
	
	@Override
	public List<Producto> getProductoByCategoria(Long idCategoria){
		return (List<Producto>)productoRepository.getByCategoriaAsc(idCategoria);
	}
	
	@Override
	public Optional<List<Producto>> getScarceProductos(int cantidad){
		return productoRepository.findByStockLessThanAndEstado(cantidad, true).map(p->(List<Producto>)p);
	}

	@Override
	public Optional<List<Producto>> getProductoByPartialName(String name) {
		return productoRepository.findByNombreContainsIgnoreCase(name).map(p->(List<Producto>)p);
	}
	
	@Override
	public Usuario login(String email, String password) {
		throw new ServiciosException("NO IMPLEMENTADO");
	}

	@Override
	public List<Categoria> getAllCategorias() {
		return (List<Categoria>) categoriaRepository.findAll();
	}
}
