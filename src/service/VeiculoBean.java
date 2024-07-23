package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.management.Query;

import db.DB;
import db.DbException;
import entity.TbVeiculo;
import querys.QueryUtil;

public class VeiculoBean implements VeiculoService{
	
	Connection conn = null;
	PreparedStatement ps = null;
	
	@Override
	public int inserir(TbVeiculo veiculo) {
		try {
			conn = DB.getConnection();
			
			ps = conn.prepareStatement(QueryUtil.insertVeiculo());
			
			ps.setInt(1, veiculo.getId());
			ps.setInt(2, veiculo.getProprietario().getId());
			ps.setString(3, veiculo.getEstado().getSigla());
			ps.setString(4, veiculo.getPlaca());
			
			return ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Não foi possível persistir os dados.");
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(ps);
			DB.closeConnection();
		}
	}

}
