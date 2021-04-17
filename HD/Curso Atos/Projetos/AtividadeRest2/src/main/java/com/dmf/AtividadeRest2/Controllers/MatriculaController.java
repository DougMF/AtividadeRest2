package com.dmf.AtividadeRest2.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmf.AtividadeRest2.Models.ChaveCompostaMatricula;
import com.dmf.AtividadeRest2.Models.Matricula;
import com.dmf.AtividadeRest2.Repositories.AlunoRepository;
import com.dmf.AtividadeRest2.Repositories.DisciplinaRepository;
import com.dmf.AtividadeRest2.Repositories.MatriculaRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Swagger2RestController", 
	description = "REST API para gerência de matrículas")
@RestController
@RequestMapping("/matricula")
public class MatriculaController{	
	@Autowired
	private MatriculaRepository matriculaRepository;
	
	@Autowired
	private DisciplinaRepository disciplinaRepository;

	@Autowired
	private AlunoRepository alunoRepository;
	
	@ApiOperation(value = "Matricula um aluno em uma disciplina", response = Iterable.class, tags = "matricularAluno")
	@PostMapping("/{alunoID}/{disciplinaID}")
	Matricula matricularAluno(@PathVariable Long alunoID, @PathVariable Long disciplinaID) {		
		Matricula matricula = new Matricula();

		matricula.setChaveCompostaMatricula(new ChaveCompostaMatricula(alunoID, disciplinaID));
		matricula.setAluno(alunoRepository.findById(alunoID).get());
		matricula.setDisciplina(disciplinaRepository.findById(disciplinaID).get());
		
		return matriculaRepository.save(matricula);
	}
	
	@ApiOperation(value = "Cancela a matrícula de um aluno com os ids do aluno e da matrícula", response = Iterable.class, tags = "deletar")
	@DeleteMapping("/{alunoID}/{disciplinaID}")
	void cancelarMatricula(@PathVariable Long alunoID, @PathVariable Long disciplinaID){
		matriculaRepository.deleteById(new ChaveCompostaMatricula(alunoID, disciplinaID));
	}
}
