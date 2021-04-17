package com.dmf.AtividadeRest2.Models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Aluno {
	@ApiModelProperty(notes = "ID do aluno", name="id", required=true)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ApiModelProperty(notes = "E-mail do aluno", name="email", required=true)
	@Column
	private String email;
	
	@ApiModelProperty(notes = "Número da matrícula do aluno", name="matricula", required=true)
	@Column
	private String matricula;
	
	@ApiModelProperty(notes = "Data de nascimento do aluno", name="dataNasc", required=true)
	@Column
	private String dataNasc;
	
	@ApiModelProperty(notes = "Nacionalidade do aluno", name="nacionalidade", required=true)
	@Column
	private String nacionalidade;
	
	@ApiModelProperty(notes = "Nome do aluno", name="nacionalidade", required=true)
	@Column
	private String nome;
	
	@ApiModelProperty(notes = "Matrículas do aluno nas disciplinas", name="matriculas", required=true)
	@OneToMany(mappedBy = "aluno")
    List<Matricula> matriculas;
	
	@PreRemove
    public void verificarMatriculas() {
        if (!this.matriculas.isEmpty()) {
            throw new RuntimeException("O aluno está matriculado em alguma disciplina");
        }
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
}
