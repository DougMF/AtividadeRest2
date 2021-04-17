package com.dmf.AtividadeRest2.Models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Disciplina {
	@ApiModelProperty(notes = "ID da disciplina", name="id", required=true)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ApiModelProperty(notes = "Nome da disciplina", name="nome", required=true)
	@Column
	private String nome;

	@ApiModelProperty(notes = "Matrículas dos alunos nesta disciplina", name="matriculas", required=true)
	@OneToMany(mappedBy = "disciplina")
    List<Matricula> matriculas;
	
	@ApiModelProperty(notes = "Quantidade máxima de vagas da disciplina", name="vagasMax", required=true)
	@Column
	private int vagasMax;
	
	@ApiModelProperty(notes = "Quantidade vagas disponíveis da disciplina", name="vagasDisp", required=true)
	@Column
	private int vagasDisp;
	
	//Garante que a quantidade de vagas disponíveis, inicialmente, seja a mesma da quantidade máxima de vagas
	@PrePersist
    public void inicializarVagasDisp() {
        vagasDisp = vagasMax;
    }
	
	@PreRemove
    public void verificarMatriculas() {
        if (!this.matriculas.isEmpty()) {
            throw new RuntimeException("Algum aluno está matriculado nesta disciplina!");
        }
    }
	
	public int getVagasMax() {
		return vagasMax;
	}

	public void setVagasMax(int vagasMax) {
		this.vagasMax = vagasMax;
	}

	public int getVagasDisp() {
		return vagasDisp;
	}

	public void setVagasDisp(int vagasDisp) {
		this.vagasDisp = vagasDisp;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
