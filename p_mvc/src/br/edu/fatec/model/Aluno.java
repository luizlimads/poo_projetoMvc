package br.edu.fatec.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**Classe para objetos do tipo Aluno, onde serão contidos, valores e métodos para o mesmo.
* @author Luiz Lima
* @since Release 0
*/
public class Aluno {
	//atributos
	private String rm;
	private String cpf;
	private String email;
	private String nome;
	private String data_nascimento;
	private String endereco;
	private String municipio;
	private String uf;
	private String curso;
	private String ano_matricula;
	private String semestre_matricula;
	private String telefone;

	
	

	/**Classe para objetos do tipo Aluno, onde serão contidos, valores e métodos para o mesmo.
	* @author Luiz Lima
	* @version 1.0
	* @since maio de 2023
	* @param rm String - valor do registro de matricula
	* @param cpf String - valor do registro de matricula
	* @param email String - valor do registro de matricula
	* @param nome String - valor do registro de matricula
	* @param data_nascimento String - valor do registro de matricula
	* @param endereco String - valor do registro de matricula
	* @param municipio String - valor do registro de matricula
	* @param uf String - valor do registro de matricula
	* @param curso String - valor do registro de matricula
	* @param ano_matricula String - ano que foi criado o aluno
	* @param semestre_matricula String - semestr que foi criado o aluno
	*/
	public Aluno(String rm, String cpf, String email, String nome, String data_nascimento, String endereco,
			String municipio, String uf, String curso, String ano_matricula, String semestre_matricula,String telefone) {
		this.rm = rm;
		setCpf(cpf);
		setEmail(email);
		this.nome = nome.strip();
		this.data_nascimento = data_nascimento;
		this.endereco = endereco;
		this.municipio = municipio;
		this.uf = uf;
		this.curso = curso;
		this.ano_matricula = ano_matricula;
		this.semestre_matricula = semestre_matricula;
	}
	
	public String getAno_matricula() {
		return ano_matricula;
	}

	public void setAno_matricula(String ano_matricula) {
		this.ano_matricula = ano_matricula;
	}

	public String getSemestre_matricula() {
		return semestre_matricula;
	}

	public void setSemestre_matricula(String semestre_matricula) {
		this.semestre_matricula = semestre_matricula;
	}

	/** Método para retorno do registro de matricula do aluno
	* @return String - Registro de Matrícula*/
	public String getRm() {
		return rm;
	}
	
	/** Método para salvar um novo registro de matricula do aluno
	* @param rm String - Registro de Matrícula, deverá ser unico e composto só por numeros*/
	public void setRm(String rm) {
		this.rm = rm;
	}

	/** Método para retorno o cpf do aluno
	* @return String - cpf, apenas os números*/
	public String getCpf() {
		return cpf;
	}

	/** Método para alterar cpf do aluno
	* @param cpf String - cpf, deve conter 11 digitos numericos de um cpf valido*/
	public void setCpf(String cpf) {
		cpf = cpf.strip();
		verificaBasicoCpf(cpf);
		verificaDigito1Cpf(cpf);
		verificaDigito2Cpf(cpf);
		this.cpf = cpf;
	}
	
	/** Método que faz a verificacao basica do cpf
	* @param cpf String - cpf, deve conter 11 digitos numericos de um cpf valido*/	
	private void verificaBasicoCpf(String cpf){
		// verificacao basica de parametros
		cpf = cpf.strip();
		// Essa verificacao deve passar
		Pattern pattern1 = Pattern.compile("[0-9]{11}");
		Matcher matcher1 = pattern1.matcher(cpf);
		boolean matchFound1 = matcher1.find();
		// Essa verificacao nao pode passar
		Pattern pattern2 = Pattern.compile("(.)\\1{10}");
		Matcher matcher2 = pattern2.matcher(cpf);
		boolean matchFound2 = matcher2.find();

		if (cpf.length() != 11 | !matchFound1 & matchFound2){
			throw new IllegalArgumentException("Cpf fora do padrao");			
		}
	}
	/** Método que checa o primeiro digito verificar do cpf, 10° digito
	* @param cpf String - cpf, deve conter 11 digitos numericos de um cpf valido*/
	private void verificaDigito1Cpf(String cpf){
		int verificadorN1 = 0;
		for(int i=0;i<9;i++){
			verificadorN1 += Character.getNumericValue(cpf.charAt(i))*(10-i);				 
		}
		verificadorN1 = verificadorN1*10 % 11 == 10 ? 0 : verificadorN1*10 % 11;
		if(verificadorN1 != Character.getNumericValue(cpf.charAt(9))) {
			throw new IllegalArgumentException("Cpf fora do padrao");
		}
	}

	/** Método que checa o segundo digito verificar do cpf, 11° digito
	* @param cpf String - cpf, deve conter 11 digitos numericos de um cpf valido*/
	private void verificaDigito2Cpf(String cpf) throws IllegalArgumentException {
		int verificadorN2 = 0;
		for(int i=0;i<10;i++){
			verificadorN2 += Character.getNumericValue(cpf.charAt(i))*(11-i);				 
		}
		verificadorN2 = verificadorN2*10 % 11 == 10 ? 0 : verificadorN2*10 % 11;
		if(verificadorN2 != Character.getNumericValue(cpf.charAt(10))) {
			throw new IllegalArgumentException("Cpf fora do padrao");
		}
	}
	
	/** Método para retorno do email cadastrado para o aluno
	* @return String - email*/
	public String getEmail() {
		return email;
	}
	
	/** Método para alterar email cadastrado para o aluno
	* @param email String - deve ser do tipo exemplo@dominio.com*/
	public void setEmail(String email) throws IllegalArgumentException{
		email = email.strip();
		Pattern pattern = Pattern.compile(".*@{1}.{3,10}.com");
		Matcher matcher = pattern.matcher(email);
		boolean matchFound = matcher.find();
		if (!matchFound){
			throw new IllegalArgumentException("Email fora do padrao");
		}
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	
}
