package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "tb_genero")
public class TipoLibro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_id_genero", nullable = false)
	public Long CodIdGenero;
	
	@Column(name = "nombregenero", nullable = false)
	public String nombregenero;

	public Long getCodIdGenero() {
		return CodIdGenero;
	}
 
	public void setCodIdGenero(Long codIdGenero) {
		CodIdGenero = codIdGenero;
	}
 
	public String getNombregenero() {
		return nombregenero;
	}

	public void setNombregenero(String nombregenero) {
		this.nombregenero = nombregenero;
	}
	
	
}
