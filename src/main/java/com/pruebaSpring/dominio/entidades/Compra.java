package com.pruebaSpring.dominio.entidades;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
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
@Table(name="compras")
public class Compra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_compra")
	private Long idCompra;
	
	@NotNull
	@Size(max = 50)
	@Column(name="id_cliente")
	private String idCliente;
	
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate fecha;
	
	@Max(300)
	private String comentario;
	
	private String estado;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente", insertable = false, updatable = false)
	private Cliente cliente;
	
	@OneToMany(mappedBy="producto")
	private List<ComprasProducto> productos;
	

}
