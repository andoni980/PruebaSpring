package com.pruebaSpring.datos;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.pruebaSpring.dominio.entidades.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long>, PagingAndSortingRepository<Producto, Long> {
	
	Optional<Iterable<Producto>> findByNombreContainsIgnoreCase(String id);
	
	default Iterable<Producto> getCaducados(){
		return findByFechaCaducidadBefore(LocalDate.now());
	}
	
	Iterable<Producto> findByFechaCaducidadBefore(LocalDate fecha);
	
	@Query("select p from Producto p where p.precio = (select max(p2.precio) from Producto p2)")
	Producto getProductoMasCaro();
	
	public Producto findFirstByOrderByPrecioDesc();
	
	@Query(nativeQuery = true,value = "SELECT * FROM productos WHERE id_categoria = ? ORDER BY nombre ASC")
	Iterable<Producto> getByCategoriaAsc(Long idCategoria);
//	Iterable<Producto> findByIdCategoriaOrderByNombreAsc(Long idCategoria);
	
	Optional<Iterable<Producto>> findByStockLessThanAndEstado(int stock, boolean estado);
	
	@Query(nativeQuery = true,value = "UPDATE productos SET nombre=?,WHERE id_categoria = ? ORDER BY nombre ASC")
	Boolean updateProducto(Long id, Producto producto);

}
