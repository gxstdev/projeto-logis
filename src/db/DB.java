package db;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {

	private static Connection conn = null;

	/*
	 * Método para conectar ao banco de dados, esse método será um objeto de conexão
	 * com o bd do JDBC.
	 * 
	 */
	public static Connection getConnection() {
		/*
		 * se o atributo acima, conn, ainda estiver null, então temos que pegar as
		 * propriedades de conexão com o método loadProperties()
		 * 
		 */
		if (conn == null) {
			try {
				/*
				 * peguei as propriedades do bd, que estão no arq db.properties
				 */
				Properties props = loadProperties();

				String url = props.getProperty("dburl");

				/*
				 * DriverManager vem do jdbc, aqui estamos criando a conexão com bd. passamos a
				 * url do banco, e as demais propriedades passando o obj props. Isso só funciona
				 * pois temos mysql connector, pois no caso estamos usando o mysql. mas se fosse
				 * postgre, teria que ser o postgre connecetor.
				 */
				conn = DriverManager.getConnection(url, props);
				String text = null;
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		return conn;
	}

	/*
	 * Fechar conexão bom o bd.
	 */
	public static void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}

	/*
	 * método privado, pois apenas a própria classe irá usá-lo um objeto dessa
	 * classe não precisa conhecer este método.
	 * 
	 * FileInputStrem classe java para ler arquivos.
	 * 
	 * Properties classe java que recebe propriedades de acesso ao bd. método .load
	 * da classe Properties carrega essas propriedades de acesso ao bd que estão no
	 * arquivo db.properties.
	 * 
	 */
	private static Properties loadProperties() {

		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fs);
			return props;
		} catch (Exception e) {
			throw new DbException(e.getMessage());
		}
	}

	public static void closeStatement(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}

	public static void closeResultSet(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
}
