package com.pruebaSpring.datos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.pruebaSpring.dominio.entidades.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>, PagingAndSortingRepository<Usuario, Long> {

	Usuario findByEmail(String email);
}
