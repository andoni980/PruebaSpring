package com.pruebaSpring.dominio.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;

import com.pruebaSpring.datos.ProductoRepository;
import com.pruebaSpring.dominio.entidades.Producto;

@Component
public class AdminProductoServicios extends UsuarioProductoServicios implements AdminServicios {
	
	public AdminProductoServicios(ProductoRepository productoRepository) {
		super(productoRepository);
	}
	
	private static final String PRODUCTO = "producto";
	
	@Override
	public void delete(Long id) {
		productoRepository.deleteById(id);
	}

	@Override
	public Producto save(Producto producto) {
		try {
			if(producto.getCodigoBarras().equals(producto.getNombre())) {
				throw new ServiciosException("No se admiten nombre iguales a un código de barras");
			}
			return productoRepository.save(producto);
		}catch(DuplicateKeyException e) {
			String dato = e.getMessage().split("'")[1];
			
			if(dato.equals(producto.getCodigoBarras())) {
				throw new ClaveDuplicadaException("el código de barras está duplicado", PRODUCTO, "codigoBarras", e);
			}else if(dato.equals(producto.getNombre())) {
				throw new ClaveDuplicadaException("ese nombre ya existe en la base de datos", PRODUCTO, "nombre", e);
			}else {
				throw new ClaveDuplicadaException("hay un campo duplicado", PRODUCTO, null, e);
			}
		}catch(ServiciosException e){
			throw e;
		}catch(Exception e) {
			throw new ServiciosException("Error no esperado al insertar", e);
		}
	}

	@Override
	public Producto update(Producto producto) {
		return productoRepository.save(producto);
	}

}
