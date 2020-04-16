package conexaojdbc;

import java.sql.Connection;
import java.sql.DriverManager;

//Conexão manual com banco de dados
public class SingleConnection {

	private static String url = "jdbc:postgresql://localhost:5432/posjava";
	private static String user = "postgres";
	private static String password = "admin";
	private static Connection connection = null;

	// Sempre que ouver alguma chamada de classe, o método conectar() será invocado.
	static {
		conectar();
	}

	public SingleConnection() {
		conectar();
	}

	private static void conectar() {
		try {
			if (connection == null) {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(url, user, password);
				connection.setAutoCommit(false);
				System.out.println("Conectou com sucesso!!!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return connection;
	}

}
