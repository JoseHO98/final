package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.TipoLibro;

public interface TipoLibroRepository extends JpaRepository<TipoLibro, Long>{

}
