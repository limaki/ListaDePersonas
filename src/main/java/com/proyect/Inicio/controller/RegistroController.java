package com.proyect.Inicio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyect.Inicio.model.ModelRegistro;
import com.proyect.Inicio.service.RegistroService;

@RestController
@RequestMapping("/ApiR")
@CrossOrigin("*")
public class RegistroController {
	
	@Autowired
	public RegistroService registroservice;
	
	
	@GetMapping("/registros")
	public List<ModelRegistro> devolverRegistros() {
		
		return registroservice.findAll();
	}
	
	@PostMapping("/registros")
	public ModelRegistro guardarRegistro(@RequestBody ModelRegistro register) {
		
		return registroservice.save(register);
	}
	
	
	@GetMapping("/registros/{id}")
	public ModelRegistro devolverOneRegistro(@PathVariable Integer id) {
		
		return registroservice.findById(id);
	}
	
	
	@PutMapping("/registros/{id}")
	public ModelRegistro editarRegistro(@RequestBody ModelRegistro register, @PathVariable Integer id) {
		
		ModelRegistro registroActual = registroservice.findById(id);
		registroActual.setImg(register.getImg());
		registroActual.setImg_costado(register.getImg_costado());
		registroActual.setNombre(register.getNombre());
		registroActual.setDescripcion(register.getDescripcion());
		registroActual.setCategoria(register.getCategoria());
		
		return registroservice.save(registroActual);
		
	}
	
	
	@DeleteMapping("/registros/{id}")
	public void eliminarRegistro(@PathVariable Integer id)
	{
		
		registroservice.delete(id);
	}
	
	

}






