package com.pruebaSpring.datos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.pruebaSpring.dominio.entidades.Categoria;

public interface CategoriaRepository extends CrudRepository<Categoria, Long>, PagingAndSortingRepository<Categoria, Long> {

}
