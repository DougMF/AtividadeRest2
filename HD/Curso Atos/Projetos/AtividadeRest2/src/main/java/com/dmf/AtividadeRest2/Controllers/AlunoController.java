package com.dmf.AtividadeRest2.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
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

import com.dmf.AtividadeRest2.Models.Aluno;
import com.dmf.AtividadeRest2.Models.Disciplina;
import com.dmf.AtividadeRest2.Repositories.AlunoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Swagger2RestController", 
	description = "REST API para gerência de alunos")
@RestController
@RequestMapping("/alunos")
public class AlunoController{
	@Autowired
	private AlunoRepository alunoRepository;
	
	@ApiOperation(value = "Cadastra um aluno e recebe-o como retorno", response = Iterable.class, tags = "adicionar")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Aluno adicionarAluno(@RequestBody Aluno aluno){
		return alunoRepository.save(aluno);
	}
	
	@ApiOperation(value = "Lista todos os alunos cadastrados", response = Iterable.class, tags = "get")
	@GetMapping
	public List<Aluno> getAlunos(){
		return alunoRepository.findAll();
	}
	
	@ApiOperation(value = "Busca um aluno por seu id", response = Iterable.class, tags = "get")
	@GetMapping("/{id}")
	Aluno getAluno(@PathVariable long id){
		return alunoRepository.findById(id).get();
	}	
	
	@ApiOperation(value = "Busca um aluno por seu id, listando todas as disciplinas nas quais ele está matriculado", response = Iterable.class, tags = "get")
	@GetMapping("/disciplinas/{alunoID}")
	Pair<Aluno, List<Disciplina>> getAlunoMatriculas(@PathVariable long alunoID){
		Aluno aluno = alunoRepository.findById(alunoID).get();
		Pair<Aluno, List<Disciplina>> pair = Pair.of(aluno, alunoRepository.getAlunoMatriculas(aluno));
		
		return pair;
	}
	
	@ApiOperation(value = "Altera um aluno, recebendo um aluno e seu ID por parâmetro. Retorna o novo aluno.", response = Iterable.class, tags = "alterar")
	@PutMapping("/{id}")
	Aluno updateAluno(@RequestBody Aluno novoAluno, @PathVariable Long id){
	    novoAluno.setId(id);
		
	    return alunoRepository.save(novoAluno);
	}
	
	@ApiOperation(value = "Exclui o aluno com o ID informado", response = Iterable.class, tags = "deletar")
	@DeleteMapping("/{id}")
	void deleteAluno(@PathVariable Long id){
		alunoRepository.deleteById(id);
	}
}
