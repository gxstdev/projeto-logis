package querys;

import java.util.List;

import entity.TbEstado;

public class QueryUtil {
	private static StringBuilder sb;

	public static String insertVeiculo() {
		sb = new StringBuilder();

		sb.append(" INSERT INTO tb_veiculo(cd_veiculo, cd_proprietario, sg_estado, ds_placa) ");
		sb.append(" VALUES ");
		sb.append(" (?, ?, ?, ?);");

		return sb.toString();
	}

	public static String selectEstados() {
		sb = new StringBuilder();
		sb.append(" SELECT * FROM tb_estado ");
		
		return sb.toString();
	}
	
	public static String selectProprietarios() {
		sb = new StringBuilder();
		sb.append(" SELECT * FROM tb_proprietario ORDER BY cd_proprietario ");
		
		return sb.toString();
	}
}
