package com.cursos.service;

import java.util.List;

import com.cursos.model.Curso;


public interface ICursoService {
	
	List<Curso> listaCursos();
	Curso buscarCurso(int codigo);
	void altaCurso(Curso curso);
	void actualizarCurso(Curso curso);
	List<Curso> eliminarCurso(int codigo);
	List<Curso> listaCursosPrecio(int minimo, int maximo);
}
