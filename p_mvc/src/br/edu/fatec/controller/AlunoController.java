package br.edu.fatec.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.fatec.dao.AlunoDAO;
import br.edu.fatec.dao.CampusDAO;
import br.edu.fatec.dao.CursosDAO;
import br.edu.fatec.dao.UfsDAO;
import br.edu.fatec.model.Aluno;
import br.edu.fatec.model.Campus;
import br.edu.fatec.model.Curso;
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
	
	
	public String salvaAluno(
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
		} catch (Exception err) {
			throw new Exception(err.getMessage());
		}
	}
	
	
	
	public String[] retornaBuscaAluno(String parametro) throws Exception{
		List<Aluno> lAlun = new ArrayList<>();
		try {
			AlunoDAO ald = new AlunoDAO();
			lAlun = ald.buscar(parametro);
			String[] res = new String[lAlun.size()];
			int i = 0;
			for(Aluno item: lAlun ){
				res[i] = String.format("%s - %s - %s", item.getRm(),item.getNome(),lCursos.get(Integer.parseInt(item.getCurso())).getNome() );
				i++;
			}
			return res;
		} catch(Exception err) {
			throw new Exception(err.getMessage());
		}
	}
	
	public Aluno buscaPorRm(String rm) throws Exception{
		try {
			AlunoDAO ald = new AlunoDAO();
			List<Aluno> lAlun = new ArrayList<>();
			lAlun = ald.buscar(rm);
			return lAlun.get(0);

		} catch(Exception err) {
			throw new Exception(err.getMessage());

		}
		
	}
	
}
