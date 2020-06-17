package com.uca.tareaLabo5.dao;

import com.uca.tareaLabo5.domain.Estudiante;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface EstudianteDAO {

    public List<Estudiante> findAll() throws DataAccessException;
    
    public Estudiante findOne(Integer code) throws DataAccessException;
    
    public void save(Estudiante estudiante) throws DataAccessException;
	
	public void delete(Integer codigo)  throws DataAccessException;
}
