package br.edu.fatec.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import br.edu.fatec.dao.AlunoDAO;
import br.edu.fatec.dao.CampusDAO;
import br.edu.fatec.dao.CursosDAO;
import br.edu.fatec.dao.UfsDAO;
import br.edu.fatec.model.Aluno;
import br.edu.fatec.model.Campus;
import br.edu.fatec.model.Curso;
import br.edu.fatec.model.Disciplina;
import br.edu.fatec.model.Ufs;
import br.edu.fatec.util.ConnectionFactory;

public class AlunoController {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private List<Ufs> lUfs;
	private List<Campus> lCampus;
	private List<Curso> lCursos;
	
	private static AlunoController uniqueInstance;

	private AlunoController()  throws SQLException {
		// chama a classe ConnectionFactory e estabele uma conexÃ£o
		try {
			buscarUfs();
			buscarCampus();
			buscarCursos();
		} catch (Exception e) {
			throw new SQLException("erro: \n" + e.getMessage());
		}
	}
	
	public List<Ufs> getlUfs() {
		return lUfs;
	}

	public List<Campus> getlCampus() {
		return lCampus;
	}

	public List<Curso> getlCursos() {
		return lCursos;
	}


	/**Retorna instancia de AlunoController.
	 * @return AlunoControler - um objeto.
	*/
	public static synchronized AlunoController getInstance() throws SQLException {
		if (uniqueInstance == null)
			uniqueInstance = new AlunoController();

		return uniqueInstance;
	}
	
	/**Método para buscar uma lista de estados.
	 * @return List<Aluno> - uma lista contendo dados pesquisados.
	*/
	public List<Ufs> buscarUfs() throws Exception {
		try {
			UfsDAO ufDao = new UfsDAO();
			this.lUfs = ufDao.buscar(); 
			return lUfs;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
	
	/**Método para buscar uma lista de campus.
	 * @return List<Campus> - uma lista contendo dados pesquisados.
	*/
	public List<Campus> buscarCampus() throws Exception {
		try {
			CampusDAO campDao = new CampusDAO();
			this.lCampus = campDao.buscar(); 
			return lCampus;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
	
	/**Método para buscar uma lista de cursos.
	 * @return List<Curso> - uma lista contendo dados pesquisados.
	*/
	public List<Curso> buscarCursos() throws Exception {
		try {
			CursosDAO curDao = new CursosDAO();
			this.lCursos = curDao.buscar();
			return this.lCursos;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
	
	/**Método para buscar salvar aluno na base de dados e retornar rm associado a ele.
	 * @param cpf String - 11 numeros de um cpf valido, apenas numeros
	 * @param email String - Email associado a aluno
	 * @param nome String - Nome do aluno
	 * @param data_nascimento String - Data de nascimento do aluno
	 * @param endereco String - Endereco do aluno  
	 * @return String - rm associado a aluno salvo.
	*/
	public String alteraSalvaAluno(
			String rm_trazido,
			String cpf,
			String email,
			String nome,
			String data_nascimento,
			String endereco,
			String municipio,
			int uf,
			int curso,
			int campus,
			String ano_matricula,
			String semestre_matricula,
			String telefone) throws Exception{
		try {
			AlunoDAO ald = new AlunoDAO();
			if(rm_trazido.equals("")) {
				int numMatriculados = ald.numeroDeMatriculados(curso, ano_matricula, semestre_matricula);
				String rm = String.format("%02d%02d%s%s%03d",campus,curso,ano_matricula,semestre_matricula,(numMatriculados+1));
				Aluno al = new Aluno(
						rm,
						cpf,
						email,
						nome,
						data_nascimento,
						endereco,
						municipio,
						Integer.toString(uf),
						Integer.toString(curso),
						ano_matricula,
						semestre_matricula,
						telefone
						);
				ald.salvar(al);
				return rm;
			}
			else {
				Aluno al = new Aluno(
						rm_trazido,
						cpf,
						email,
						nome,
						data_nascimento,
						endereco,
						municipio,
						Integer.toString(uf),
						Integer.toString(curso),
						ano_matricula,
						semestre_matricula,
						telefone
						);
				ald.alterar(al);
				return rm_trazido;				
			}
		} catch (Exception err) {
			throw new Exception(err.getMessage());
		}
	}
	
	
	/**Método para buscar informacoes resumidas de aluno.
	 * @param parametro String - 11 ou 12 numeros  
	 * @return String[] - resumo encontrado.
	*/
	public String[] buscaResultadoResumido(String parametro) throws Exception{
		List<Aluno> lAlun = new ArrayList<>();
		try {
			AlunoDAO ald = new AlunoDAO();
			if(parametro.length()==11) {
				lAlun = ald.buscaPorCpf(parametro);
//				é um cpf
				}
			else if(parametro.length()==12) {
				lAlun = ald.buscaPorRm(parametro);
//				é um RM
			}
			if(lAlun.size() > 0) {
				String[] res = new String[lAlun.size()];
				int i =0;
				for(Aluno item:lAlun){
					res[i] = String.format("%s - %s - %s", item.getRm(),item.getNome(),lCursos.get(Integer.parseInt(item.getCurso())).getNome() );
					i++;
				}				
				return res;
			}
			else {
				throw new Exception("Nenhum usuario encontrado");
			}
		} catch(Exception err) {
			throw new Exception("Erro na busca");
		}
	}
	
		
	public Aluno buscaPorRm(String rm) throws Exception{
		try {
			AlunoDAO ald = new AlunoDAO();
			List<Aluno> lAlun = new ArrayList<>();
			lAlun = ald.buscaPorRm(rm);
			return lAlun.get(0);

		} catch(Exception err) {
			throw new Exception(err.getMessage());

		}
	}

	public List<Disciplina> buscaDisciplinaCursada(String rm) throws Exception{
		try {
			AlunoDAO ald = new AlunoDAO();
			List<Disciplina> lDisc = new ArrayList<>();
			lDisc = ald.disciplinasFeitas(rm);
			return lDisc;

		} catch(Exception err) {
			throw new Exception(err.getMessage());

		}
	}
	
	public String[] buscaNotasEFaltas(String rm, String nome_curso, String ano_matricula, String semestre_matricula)  throws Exception{
		try {
			AlunoDAO ald = new AlunoDAO();
			String[] res = new String[2];
			res = ald.notasFaltas(rm, nome_curso, ano_matricula, semestre_matricula);
			return(res);			
		} catch(Exception err) {
			throw new Exception(err.getMessage());
		}
	}
	
	public void atualizaNotasEFalatas(String rm, String nome_curso, String ano_matricula, String semestre_matricula, String nota, String falta) throws Exception{
		try {
			AlunoDAO ald = new AlunoDAO();
			ald.atualizaNotasFaltas(rm, nome_curso, ano_matricula, semestre_matricula, nota, falta);			
		} catch(Exception err) {
			throw new Exception(err.getMessage());
		}
	}
	
	public void excluiAluno(String rm) throws Exception{
		try {
			AlunoDAO ald = new AlunoDAO();
			ald.apaga(rm);
		} catch(Exception err) {
			throw new Exception(err.getMessage());
		}
	}
	
	public List<String> mostraBoletim(String rm) throws Exception{
		try {
			AlunoDAO ald = new AlunoDAO();
			List<String> res = new ArrayList<>();
			res = ald.boletim(rm);
			return(res);
		} catch(Exception err) {
			throw new Exception(err.getMessage());
		}
		
	}
}
