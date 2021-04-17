package com.dmf.AtividadeRest2.Models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import io.swagger.annotations.ApiModelProperty;

@Embeddable
public class ChaveCompostaMatricula implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(notes = "ID do aluno", name="alunoID", required=true)
	@Column(name = "alunoID", nullable = false)
    private long alunoID;

	@ApiModelProperty(notes = "ID da disciplina", name="disciplinaID", required=true)
    @Column(name = "disciplinaID", nullable = false)
    private long disciplinaID;

	public ChaveCompostaMatricula() {
		
	}
	
	public ChaveCompostaMatricula(long alunoID, long disciplinaID) {
		this.alunoID = alunoID;
		this.disciplinaID = disciplinaID;
	}
	
	public long getAlunoID() {
		return alunoID;
	}

	public void setAlunoID(long alunoID) {
		this.alunoID = alunoID;
	}

	public long getDisciplinaID() {
		return disciplinaID;
	}

	public void setDisciplinaID(long disciplinaID) {
		this.disciplinaID = disciplinaID;
	}
}