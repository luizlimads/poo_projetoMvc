package br.edu.fatec.model;

public class Ufs {
	private int id;
	private String nome;
	private String abreviacao;
	
	public Ufs(int id, String nome, String abreviacao) {
		this.id = id;
		this.nome = nome;
		this.abreviacao = abreviacao;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getAbreviacao() {
		return abreviacao;
	}
	
	
	
}
