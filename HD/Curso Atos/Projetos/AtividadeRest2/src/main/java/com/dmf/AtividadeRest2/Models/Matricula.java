package com.dmf.AtividadeRest2.Models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Matricula {
	@ApiModelProperty(notes = "ID da matrícula, chave composta com os ids de aluno e disciplina", name="id", required=true)
	@EmbeddedId
	private ChaveCompostaMatricula chaveCompostaMatricula;

	@ManyToOne
    @MapsId("alunoID")
    @JoinColumn(name = "alunoID")
	private Aluno aluno;
	
	@ManyToOne
    @MapsId("disciplinaID")
    @JoinColumn(name = "disciplinaID")
	private Disciplina disciplina;

	@PrePersist
    public void reduzirVagas() {
        disciplina.setVagasDisp(disciplina.getVagasDisp() - 1);
    }
	
	@PreRemove
    public void aumentarVagas() {
        disciplina.setVagasDisp(disciplina.getVagasDisp() + 1);
    }
	
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	public ChaveCompostaMatricula getChaveCompostaMatricula() {
		return chaveCompostaMatricula;
	}

	public void setChaveCompostaMatricula(ChaveCompostaMatricula chaveCompostaMatricula) {
		this.chaveCompostaMatricula = chaveCompostaMatricula;
	}
}