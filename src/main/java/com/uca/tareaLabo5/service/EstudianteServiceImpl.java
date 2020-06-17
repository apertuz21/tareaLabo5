package com.uca.tareaLabo5.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.tareaLabo5.dao.EstudianteDAO;
import com.uca.tareaLabo5.domain.Estudiante;
import com.uca.tareaLabo5.repositories.EstudianteRepo;

@Service
public class EstudianteServiceImpl implements EstudianteService {
	
	@Autowired
	EstudianteRepo estudianteRepo;
	//EstudianteDAO estudianteDAO;
	
	@Override
	public List<Estudiante> findAll() throws DataAccessException{
		return estudianteRepo.findAll();
	}
	
	@Override
	public Estudiante findOne(Integer codigo) throws DataAccessException {
		return estudianteRepo.getOne(codigo);
	}
	
	@Override
	public void save(Estudiante estudiante) throws DataAccessException {
		estudianteRepo.save(estudiante);
	}
	
	@Override
	public void delete(Integer codigo) throws DataAccessException {
		estudianteRepo.deleteById(codigo); 
	}
	
	@Override
	public List <Estudiante> filtrarPor(String cadena) throws DataAccessException {
		return estudianteRepo.findByNombre(cadena); 
	}
	
	@Override
	public List <Estudiante> startWith(String cadena) throws DataAccessException {
		return estudianteRepo.findByApellidoStartingWith(cadena); 
	}
	
	
}
