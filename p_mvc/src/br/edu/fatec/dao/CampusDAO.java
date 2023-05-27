package br.edu.fatec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.fatec.model.Campus;
import br.edu.fatec.util.ConnectionFactory;

public class CampusDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public CampusDAO(){
		
	}
	
	/**Método para listar os campus cadastrados.
	 * @return List<Campus> - uma lista contendo dados pesquisados.
	*/
	public List<Campus> buscar() throws Exception {
		try {
			this.conn = ConnectionFactory.getConnection();
			String SQL = String.format("SELECT * FROM campus");
			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery();
			List<Campus> lCampus = new ArrayList<>();
			while (rs.next()) {
				Campus camp = new Campus(
						Integer.parseInt(rs.getString("id")),
						rs.getString("nome"));
				lCampus.add(camp);
				}
			return lCampus;
		} catch (Exception e) {
			throw new Exception("Erro ao buscar dados Campus");
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}

}
