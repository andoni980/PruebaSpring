package com.pruebaSpring.dominio.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebaSpring.datos.ProductoRepository;
import com.pruebaSpring.datos.UsuarioRepository;
import com.pruebaSpring.dominio.entidades.Producto;
import com.pruebaSpring.dominio.entidades.Usuario;

import lombok.extern.java.Log;

@Log
@Service
public class UsuarioProductoServicios implements UsuarioServicios{

	@Autowired
	ProductoRepository productoRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
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
		
		Usuario usuario = usuarioRepository.findByEmail(email);
		
		if(usuario != null && usuario.getPassword().equals(password)) {
			log.fine(String.format("El usuario %s se ha logueado", email));
			return usuario;
		}
		
		log.warning(String.format("El usuario %s con la contraseña %s no es válido", email, password));
		
		return null;
	}
}
