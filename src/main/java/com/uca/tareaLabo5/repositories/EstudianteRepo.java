package com.uca.tareaLabo5.repositories;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uca.tareaLabo5.domain.Estudiante;

public interface EstudianteRepo extends JpaRepository<Estudiante, Integer> {
	
	public List <Estudiante> findByNombre(String cadena) throws DataAccessException;
	
	public List <Estudiante> findByApellidoStartingWith(String cadena) throws DataAccessException;

}
