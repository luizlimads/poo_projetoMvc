package br.edu.fatec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.fatec.model.Aluno;
import br.edu.fatec.model.Matricula;
import br.edu.fatec.util.ConnectionFactory;

/**Classe para comunicar com o banco de dados informacoes do aluno.
 * @author Luiz Lima.
*/
public class AlunoDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	List<Aluno> lAlun;
	
	public AlunoDAO() throws SQLException {
		// chama a classe ConnectionFactory e estabele uma conexÃ£o

	}
	
	
	/**Método para salvar o aluno na base de dados.
	 * @param aluno Aluno - objeto da classe Aluno.
	*/
	public void salvar(Aluno aluno) throws Exception {
		if (aluno == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			this.conn = ConnectionFactory.getConnection();

			String SQL = String.format("INSERT INTO "
					+ "alunos(rm, cpf, email, nome, data_nascimento, endereco, municipio, uf, curso, ano_matricula, semestre_matricula,telefone) "
					+ "values('%s', '%s', '%s', '%s', '%s', '%s', '%s', %s, %s, '%s', '%s','%s');",
					aluno.getRm(),
					aluno.getCpf(),
					aluno.getEmail(),
					aluno.getNome(),
					aluno.getData_nascimento(),
					aluno.getEndereco(),
					aluno.getMunicipio(),	
					aluno.getUf(),
					aluno.getCurso(),
					aluno.getAno_matricula(),
					aluno.getSemestre_matricula(),
					aluno.getTelefone()
					);
			ps = conn.prepareStatement(SQL);
			ps.executeUpdate();
		} catch (SQLException sqle) {
			throw new Exception("Erro ao inserir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
	
	/**Método para deletar um aluno da base de dados.
	 * @param rm String - Identificação unica do aluno.
	*/
	public void deletar(String rm) throws Exception {
		if (rm == null)
			throw new IllegalArgumentException("O valor passado nao pode ser nulo");
		try {
			String SQL = String.format("DELETE FROM alunos "
					+ "WHERE rm = '%s';",
					rm
					);
			ps = conn.prepareStatement(SQL);
			ps.executeUpdate();
		} catch (SQLException sqle) {
			throw new Exception("Erro ao inserir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
	
	/**Método para buscar uma lista de alunos da base de dados.
	 * @param parametro String - Identificação do aluno por rm ou cpf.
	 * @return List<Aluno> - uma lista contendo dados pesquisados.
	*/
	public List<Aluno> buscar(String parametro) throws Exception {
		if (parametro == null)
			throw new IllegalArgumentException("O valor passado nao pode ser nulo");
		try {
			this.conn = ConnectionFactory.getConnection();
			String SQL;
			if (parametro.length() == 12) {
				SQL = String.format("SELECT * FROM alunos "
						+ "WHERE rm = '%s';",
						parametro
						);
			}
			else if (parametro.length() == 11) {
				SQL = String.format("SELECT * FROM alunos "
						+ "WHERE cpf = '%s';",
						parametro
						);
			}
			else {
				throw new IllegalArgumentException("O valor passado nao pode corresponder aos parametros");
			}
			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery();
			List<Aluno> lAlun = new ArrayList<>();
			while (rs.next()) {
				Aluno alun = new Aluno(
						rs.getString("rm"),
						rs.getString("cpf"),
						rs.getString("email"),
						rs.getString("nome"),
						rs.getString("data_nascimento"),
						rs.getString("endereco"),
						rs.getString("municipio"),
						rs.getString("uf"),
						rs.getString("curso"),
						rs.getString("ano_matricula"),
						rs.getString("semestre_matricula"),
						rs.getString("telefone")
						);
				lAlun.add(alun);
				}
			return lAlun;
		} catch (SQLException sqle) {
			throw new Exception("Erro ao inserir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
	
	
	/**Método para alterar o aluno na base de dados.
	 * @param aluno Aluno - objeto da classe Aluno.
	*/
	public void alterar(Aluno aluno) throws Exception {
		if (aluno == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = String.format("UPDATE alunos SET "
					+ "cpf = '%s', email = '%s', nome = '%s', data_nascimento = '%s', endereco = '%s', municipio = '%s', uf = %s, curso = %s "
					+ "WHERE rm = '%s'",
					aluno.getCpf(),
					aluno.getEmail(),
					aluno.getNome(),
					aluno.getData_nascimento(),
					aluno.getEndereco(),
					aluno.getMunicipio(),	
					aluno.getUf(),
					aluno.getCurso(),
					aluno.getRm()
					);
			ps = conn.prepareStatement(SQL);
			ps.executeUpdate();
		} catch (SQLException sqle) {
			throw new Exception("Erro ao inserir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
	
	/**Método para buscar uma lista de alunos da base de dados.
	 * @param parametro String - Identificação do aluno por rm ou cpf.
	 * @return List<Aluno> - uma lista contendo dados pesquisados.
	*/
	public List<Matricula> matriculasFeitas(String rm) throws Exception {
		if (rm == null)
			throw new IllegalArgumentException("O valor passado nao pode ser nulo");
		try {
			this.conn = ConnectionFactory.getConnection();

			String SQL = String.format("SELECT d.nome, m.ano, m.semestre, m.turno, m.nota, m.n_faltas FROM matriculados m "
					+ "INNER JOIN alunos a ON m.aluno = a.rm "
					+ "INNER JOIN disciplinas d ON m.disciplina = d.id "
					+ "WHERE rm = '%s' "
					+ "ORDER BY "
					+ "  m.ano, "
					+ "  m.semestre, "
					+ "  m.turno, "
					+ "  d.nome; ",
					rm
					);
			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery();
			List<Matricula> lDisc = new ArrayList<>();
			while (rs.next()) {
				Matricula disc = new Matricula(
						rs.getString("nome"),
						rs.getString("ano"),
						rs.getString("semestre"),
						rs.getString("turno"),
						rs.getString("nota"),
						rs.getString("n_faltas")
						);
				lDisc.add(disc);
				}
			return lDisc;
		} catch (SQLException sqle) {
			throw new Exception("Erro ao inserir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
	
	public int numeroDeMatriculados(int curso, String ano_matricula, String semestre_matricula)
			throws Exception{
		this.conn = ConnectionFactory.getConnection();
		int res = 0;
		String SQL = String.format("SELECT COUNT(rm) as cnt FROM alunos "
				+ "where (curso=%s AND ano_matricula=%s AND semestre_matricula=%s);",
				curso,ano_matricula,semestre_matricula);
		try {
			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery();
			while(rs.next()) {
				res = rs.getInt("cnt");
			}
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
		return res;
	}

}
