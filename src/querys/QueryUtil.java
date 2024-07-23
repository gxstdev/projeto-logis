package querys;

public class QueryUtil {
	private static StringBuilder sb;
	
	public static String insert() {
		sb = new StringBuilder();
		
		sb.append(" INSERT INTO tb_veiculo(cd_veiculo, cd_proprietario, sg_estado, ds_placa) ");
		sb.append(" VALUES ");
		sb.append(" (?, ?, ?, ?);");
		
		return sb.toString();
	}
}
