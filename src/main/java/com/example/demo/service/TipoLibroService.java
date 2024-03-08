package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.TipoLibro;
import com.example.demo.repository.TipoLibroRepository;

@Service
public class TipoLibroService {
	
	@Autowired
	private TipoLibroRepository tipolibroRepository;
	
	public List<TipoLibro> getAllTipoLibro(){
		return tipolibroRepository.findAll();
		}
	
	public TipoLibro getTipoLibroById(Long id) {
		return tipolibroRepository.findById(id).orElse(null);
	}
	
}
