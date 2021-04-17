package com.dmf.AtividadeRest2.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dmf.AtividadeRest2.Models.Disciplina;
import com.dmf.AtividadeRest2.Repositories.DisciplinaRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Swagger2RestController", 
	description = "REST API para gerência de disciplinas")
@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController{
	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	@ApiOperation(value = "Cadastra uma disciplina e recebe-a como retorno", response = Iterable.class, tags = "adicionar")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Disciplina adicionarDisciplina(@RequestBody Disciplina disciplina){
		return disciplinaRepository.save(disciplina);
	}
	
	@ApiOperation(value = "Lista todas as disciplinas cadastradas", response = Iterable.class, tags = "get")
	@GetMapping
	public List<Disciplina> getDisciplinas(){
		return disciplinaRepository.findAll();
	}
	
	@ApiOperation(value = "Lista todas as disciplinas com vagas disponíveis", response = Iterable.class, tags = "get")
	@GetMapping("/ofertadas")
	public List<Disciplina> getDisciplinasOfertadas(){
		return disciplinaRepository.getOfertadas();
	}
	
	@ApiOperation(value = "Busca uma disciplina por seu id", response = Iterable.class, tags = "get")
	@GetMapping("/{id}")
	Disciplina getDisciplina(@PathVariable long id){
		return disciplinaRepository.findById(id).get();
	}
	
	@ApiOperation(value = "Altera uma disciplina, recebendo uma disciplina e seu ID por parâmetro. Retorna a nova disciplina.", response = Iterable.class, tags = "alterar")
	@PutMapping("/{id}")
	Disciplina updateDisciplina(@RequestBody Disciplina novaDisciplina, @PathVariable Long id){
		novaDisciplina.setId(id);
		
	    return disciplinaRepository.save(novaDisciplina);
	}
	
	@ApiOperation(value = "Exclui a disciplina com o ID informado", response = Iterable.class, tags = "deletar")
	@DeleteMapping("/{id}")
	void deleteDisciplina(@PathVariable Long id){
		disciplinaRepository.deleteById(id);
	}
}
