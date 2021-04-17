package com.dmf.AtividadeRest2.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dmf.AtividadeRest2.Models.ChaveCompostaMatricula;
import com.dmf.AtividadeRest2.Models.Matricula;


@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, ChaveCompostaMatricula>{
}
