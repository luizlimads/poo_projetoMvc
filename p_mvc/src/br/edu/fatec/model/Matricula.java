package br.edu.fatec.model;

public class Matricula {
	private String nome;
	private String ano;
	private String semestre;
	private String turno;
	private String nota;
	private String numeroFaltas;
	public Matricula(String nome, String ano, String semestre, String turno, String nota, String numeroFaltas) {
		this.nome = nome;
		this.ano = ano;
		this.semestre = semestre;
		this.turno = turno;
		this.nota = nota;
		this.numeroFaltas = numeroFaltas;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getSemestre() {
		return semestre;
	}
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public String getNota() {
		return nota;
	}
	public void setNota(String nota) {
		this.nota = nota;
	}
	public String getNumeroFaltas() {
		return numeroFaltas;
	}
	public void setNumeroFaltas(String numeroFaltas) {
		this.numeroFaltas = numeroFaltas;
	}
	
	
	
	
}
