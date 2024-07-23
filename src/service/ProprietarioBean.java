package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import entity.TbProprietario;
import querys.QueryUtil;

public class ProprietarioBean implements ProprietarioService{
	private Connection conn = null;
	private Statement st = null;
	private ResultSet rs = null;
	
	@Override
	public List<TbProprietario> buscarProprietarios() {
		List<TbProprietario> list = new ArrayList<TbProprietario>();
		
		try {
			conn = DB.getConnection();
			st = conn.createStatement();
			
			rs = st.executeQuery(QueryUtil.selectProprietarios());
			
			while (rs.next()) {
				Integer id = rs.getInt("cd_proprietario");
				String nome = rs.getString("nm_proprietario");
				
				list.add(new TbProprietario(id, nome));
			}
			
			return list;
		} catch (SQLException e) {
			System.out.println("Não foi possível realizar os selects.");
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
			DB.closeConnection();
		}
	}

}
