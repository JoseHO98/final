package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name= "tb_libro")
public class Libro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Long id;
	
	@Column(name="nombrelibro", nullable = false)
	public String nombrelibro;
	
	@Column(name="autor", nullable = false)
	public String autor;
	
	@Column(name="fechapublicacion", nullable = false)
	public String fechapublicacion;
	 
	@ManyToOne
	@JoinColumn(name="tipogenero", nullable = false)
	public TipoLibro TipoLibro;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombrelibro() {
		return nombrelibro;
	}

	public void setNombrelibro(String nombrelibro) {
		this.nombrelibro = nombrelibro;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getFechapublicacion() {
		return fechapublicacion;
	}

	public void setFechapublicacion(String fechapublicacion) {
		this.fechapublicacion = fechapublicacion;
	}

	public TipoLibro getTipoLibro() {
		return TipoLibro;
	}

	public void setTipoLibro(TipoLibro tipoLibro) {
		TipoLibro = tipoLibro;
	}

}
