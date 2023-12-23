package com.pruebaSpring.dominio.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.hibernate.validator.constraints.EAN;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name="productos")
public class Producto {
	
	@Id
	@Column(name="id_producto")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idProducto;
	
	@NotBlank
	@NotNull
	@Size(min = 2, max = 50)
	private String nombre;
	
	@NotNull
	@Column(name="id_categoria")
	private Long idCategoria;
	
	@NotNull
	@Pattern(regexp = "^\\d{13}$", message = "debe tener 13 dígitos")
	@Size(min = 13, max = 13, message = "debe ser 13 caracteres exactos")
	@EAN
	@Column(columnDefinition = "CHAR(13)")
	private String codigoBarras;
	
	@NotNull
	@Min(0)
	private BigDecimal precio;
	
	@NotNull
	@Min(0)
	private Integer stock;
	
	@NotNull
	private Boolean estado;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Future
	private LocalDate fechaCaducidad;
	
	@ManyToOne
	@JoinColumn(name = "id_categoria", insertable = false, updatable = false)
	private Categoria categoria;
	
	
	// Lista de compras en la que aparece determinado producto !!! La necesito???
//	@OneToMany(mappedBy="productos")
//	private List<ComprasProducto> compras;
	
	
	
	

}
