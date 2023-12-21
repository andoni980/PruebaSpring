package com.pruebaSpring.dominio.entidades;

import java.math.BigDecimal;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@Entity
@Table(name="compras_producto")
public class ComprasProducto {

	@EmbeddedId
	private ComprasProductoPK id_compras_productoPK;
	
	@Min(0)
	private Integer cantidad;
	
	@Min(0)
	private BigDecimal total;
	
	private Boolean estado;
	
	@ManyToOne
	@JoinColumn(name = "id_producto", insertable = false, updatable = false)
	private Producto producto;
	
	@ManyToOne
	@JoinColumn(name="id_compra", insertable = false, updatable = false)
	private Compra compra;
}
