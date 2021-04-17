package com.dmf.AtividadeRest2.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dmf.AtividadeRest2.Models.Disciplina;


@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long>{
	@Query("select d from Disciplina d where d.vagasDisp > 0")
	List<Disciplina> getOfertadas();
}