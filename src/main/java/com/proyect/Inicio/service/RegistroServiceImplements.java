package com.proyect.Inicio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyect.Inicio.dao.DaoRegistro;
import com.proyect.Inicio.model.ModelRegistro;


@Service
public class RegistroServiceImplements implements RegistroService{
	
	@Autowired
	public DaoRegistro daoregistro;

	
	
	@Override
	@Transactional(readOnly = true)
	public List<ModelRegistro> findAll() {
		
		return (List<ModelRegistro>)daoregistro.findAll();
	}

	@Override
	@Transactional(readOnly = false)
	public ModelRegistro save(ModelRegistro registro) {
		
		return daoregistro.save(registro);
	}

	@Override
	@Transactional(readOnly = true)
	public ModelRegistro findById(Integer id) {
		
		return daoregistro.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Integer id) {
		
		 daoregistro.deleteById(id);
	}
	

	

}
