package com.pruebaSpring.dominio.entidades;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
@Table(name="categorias")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_categoria")
	private Long idCategoria;
	
	@NotBlank
	@NotNull
	@Size(min = 2, max = 30)
	private String nombre;
	
	@NotBlank
	@NotNull
	@Size(min = 2, max = 150)
	private String descripcion;
	
	@NotNull
	private Boolean estado;
	
	@OneToMany(mappedBy = "categoria")
	private List<Producto> productos;
	
}
