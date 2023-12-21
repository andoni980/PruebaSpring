package com.pruebaSpring.dominio.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name="usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_cliente")
	private Long idUsuario;
	
	@NotNull
	@NotBlank
	@Size(min=2, max=40)
	private String email;
	
	@NotBlank
	@NotNull
	@Size(min = 2, max = 40)
	private String nombre;
	
	@NotNull
	@NotBlank
	@Size(max = 20)
	private String password;
	
	@NotNull
	@NotBlank
//	@DniValido
	@Size(min = 8, max = 10)
	private String dni;
	
	@NotNull
	@Column(name="id_rol")
	private Long idRol;

}
