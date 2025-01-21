package com.cursos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.cursos.model.Curso;

@Service
public class CursoServiceImp implements ICursoService {
	
	List<Curso> cursos;
	
	public CursoServiceImp() {
		cursos=new ArrayList<>();
		cursos.add(new Curso(001,"Matematicas","50", 300));
		cursos.add(new Curso(002, "Lengua", "40", 260));
		cursos.add(new Curso(003,"Programacion","50",330));
		cursos.add(new Curso(004,"Fisica","70",350));
	}

	@Override
	public List<Curso> listaCursos() {
		
		return cursos;
	}

	@Override
	public Curso buscarCurso(int codigo) {
		return cursos
				.stream()
				.filter(c->c.getCodCurso()== codigo)
				.findFirst()
				.orElse(null);
	}

	@Override
	public void altaCurso(Curso curso) {
		cursos.add(curso);
		
	}

	@Override
	public void actualizarCurso(Curso curso) {
		Curso c=buscarCurso(curso.getCodCurso());
		if(c!=null) {
			c.setDuracion(curso.getDuracion());
			c.setNombre(curso.getNombre());
			c.setPrecio(curso.getPrecio());
		}
		
	}

	@Override
	public List<Curso> eliminarCurso(int codigo) {
		cursos.removeIf(c->c.getCodCurso()==codigo);
		return cursos;
	}

	@Override
	public List<Curso> listaCursosPrecio(int minimo, int maximo) {
		  return cursos
		            .stream()
		            .filter(c -> c.getPrecio() >= minimo && c.getPrecio() <= maximo) // Filtrar por rango de precios
		            .collect(Collectors.toList()); // Recopilar los resultados en una lista
	}
	
	
	

	
	
}
