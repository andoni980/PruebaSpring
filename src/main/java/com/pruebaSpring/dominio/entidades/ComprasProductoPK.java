package com.pruebaSpring.dominio.entidades;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
@Embeddable
public class ComprasProductoPK implements Serializable{

	private static final long serialVersionUID = 1L;

	@NotNull
	@Column(name="id_compra")
	private Long idCompra;
	
	@NotNull
	@Column(name="id_producto")
	private Long idProducto;
}
