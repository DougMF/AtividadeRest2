package com.dmf.AtividadeRest2.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dmf.AtividadeRest2.Models.Aluno;
import com.dmf.AtividadeRest2.Models.Disciplina;


@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>{
	@Query("select m.disciplina from Matricula m"
			+ " where m.aluno = :aluno")
	List<Disciplina> getAlunoMatriculas(@Param("aluno") Aluno aluno);
}