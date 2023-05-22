package com.proyect.Inicio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyect.Inicio.model.ModelRegistro;

@Service
public interface RegistroService {
	
	public List<ModelRegistro> findAll();
	
	public ModelRegistro save(ModelRegistro register);
	
	public ModelRegistro findById(Integer id);
	
	public void delete(Integer id);

}
