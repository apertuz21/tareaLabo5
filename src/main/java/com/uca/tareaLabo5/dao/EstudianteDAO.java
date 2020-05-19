package com.uca.tareaLabo5.dao;

import com.uca.tareaLabo5.domain.Estudiante;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface EstudianteDAO {

    public List<Estudiante> findAll() throws DataAccessException;
    
    public void insert(Estudiante estudiante) throws DataAccessException;
}
