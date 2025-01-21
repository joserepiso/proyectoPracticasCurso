package com.cursos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.cursos.model.Curso;
import com.cursos.service.CursoServiceImp;

@RestController
public class CursoController {
	
	@Autowired
	CursoServiceImp service;
	
	
	@GetMapping(value="curso/{codigo}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Curso buscarCurso(@PathVariable("codigo") int codigo) {
		return service.buscarCurso(codigo);
	}
	
	@GetMapping(value="cursos",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> listadoCursos() {
		return service.listaCursos();
	}
	
	@PostMapping(value="curso",consumes=MediaType.APPLICATION_JSON_VALUE)
	public void insertarCurso(@RequestBody Curso  curso) {
		service.altaCurso(curso);
	}
	
	@PutMapping(value="curso",consumes=MediaType.APPLICATION_JSON_VALUE)
	public void actualizarCurso(@RequestBody Curso curso) {
		service.actualizarCurso(curso);
	}
	
	@DeleteMapping(value="curso/{codigo}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> eliminarCurso(@PathVariable("codigo") int codigo){
		return service.eliminarCurso(codigo);
	}

	@GetMapping(value="cursos/{min}/{man}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> listadoCursosPorPrecio(@PathVariable("man") int man, @PathVariable("min") int min) {
		return service.listaCursosPrecio(min, man);
	}
}
