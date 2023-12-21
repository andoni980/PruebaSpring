package com.pruebaSpring.datos;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.pruebaSpring.dominio.entidades.Producto;

public interface ProductoCrudRepository extends CrudRepository<Producto, Long>, PagingAndSortingRepository<Producto, Long> {

	Iterable<Producto> findByNombreContainsIgnoreCase(String id);
	
	Iterable<Producto> findByFechaCaducidadBefore(LocalDate fecha);
	
	
	// @Query(nativeQuery = true, "SELECT MAX(precio) FROM productos")
	@Query("select p from Producto p where p.precio = (select max(p2.precio) from Producto p2)")
	Producto getProductoMasCaro();
	
	Producto findFirstByOrderByPrecioDesc();
	
	
	// Los nativeQuery pueden llamarse de cualquier manera
//	@Query(nativeQuery = true,value = "SELECT * FROM productos WHERE id_categoria = ?")
//	Iterable<Producto> getByCategoria(Long idCategoria);
	Iterable<Producto> findByIdCategoriaOrderByNombreAsc(Long idCategoria);
	
	Optional<Iterable<Producto>> findByStockLessThanAndEstado(int stock, boolean estado);
}
