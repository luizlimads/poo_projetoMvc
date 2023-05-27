package br.edu.fatec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.fatec.model.Curso;
import br.edu.fatec.util.ConnectionFactory;

public class CursosDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public CursosDAO(){
		
	}
	
	/**Método para listar os cursos cadastrados.
	 * @return List<Curso> - uma lista contendo dados pesquisados.
	*/
	public List<Curso> buscar() throws Exception {
		try {
			this.conn = ConnectionFactory.getConnection();
			String SQL = String.format("SELECT * FROM cursos");
			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery();
			List<Curso> lCursos = new ArrayList<>();
			while (rs.next()) {
				Curso cur = new Curso(
						Integer.parseInt(rs.getString("id")),
						rs.getString("nome"));
				lCursos.add(cur);
				}
			return lCursos;
		} catch (Exception e) {
			throw new Exception("Erro ao buscar dados Curso");
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}

}
