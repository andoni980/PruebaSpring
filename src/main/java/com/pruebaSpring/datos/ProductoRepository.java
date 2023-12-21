package com.pruebaSpring.datos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.pruebaSpring.dominio.entidades.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long>, PagingAndSortingRepository<Producto, Long> {

}
