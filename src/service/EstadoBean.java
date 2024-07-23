package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import entity.TbEstado;
import querys.QueryUtil;

public class EstadoBean implements EstadoService {
	private Connection conn = null;
	private Statement st = null;
	private ResultSet rs = null;
	
	@Override
	public List<TbEstado> buscarEstados() {
		List<TbEstado> list = new ArrayList<TbEstado>();
		
		try {
			conn = DB.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(QueryUtil.selectEstados());
			
			while (rs.next()) {
				String sigla = rs.getString("sg_estado");
				String nome = rs.getString("nm_estado");
				
				TbEstado tbEstado = new TbEstado(sigla, nome);
				
				list.add(tbEstado);
			}
			
			return list;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

}
