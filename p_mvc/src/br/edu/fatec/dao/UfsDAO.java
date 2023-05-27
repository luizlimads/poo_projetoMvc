package br.edu.fatec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.fatec.model.Ufs;
import br.edu.fatec.util.ConnectionFactory;

public class UfsDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public UfsDAO(){
		
	}
	
	/**Método para listar os estados cadastrados.
	 * @return List<Ufs> - uma lista contendo dados pesquisados.
	*/
	public List<Ufs> buscar() throws Exception {
		try {
			this.conn = ConnectionFactory.getConnection();
			String SQL = String.format("SELECT * FROM estados");
			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery();
			List<Ufs> lUfs = new ArrayList<>();
			while (rs.next()) {
				Ufs uf = new Ufs(Integer.parseInt(rs.getString("id")), rs.getString("nome"), rs.getString("abreviacao") );
				lUfs.add(uf);
				}
			return lUfs;
		} catch (Exception e) {
			throw new Exception("Erro ao buscar dados Ufs");
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
	

}
