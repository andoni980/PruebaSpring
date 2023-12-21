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
@Table(name="clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_cliente")
	private Long idCliente;
	
	@NotBlank
	@NotNull
	@Size(min = 2, max = 40)
	private String nombre;
	
	@Size(max = 100)
	private String apellidos;
	
	@NotBlank
	@NotNull
	@Size(max=12)
	private String telefono;
	
	@Size(max=80)
	private String direccion;
	
	@NotNull
	@NotBlank
	@Size(min=2, max=40)
	private String email;
	
	private String ficheros;
	
	@NotNull
	@NotBlank
	@Size(min = 8, max = 10)
//	@DniValido
	private String dni;
	
	@OneToMany(mappedBy= "cliente")
	private List<Compra> compras;
	
}
