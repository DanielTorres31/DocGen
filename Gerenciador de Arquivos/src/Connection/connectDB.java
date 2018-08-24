package Connection;

import java.sql.*;

public class connectDB {
	
	static Connection conn = null;

	public static Connection CriarConexao() {

		// Configura��o dos par�metros de conex�o
        String server = "192.168.0.41";
        String port = "1521";  // Porta TCP padr�o do Oracle
        String database = "uganda.nosmoke";

        // Configura��o dos par�metros de autentica��o
        String user = "req";
        String passwd = "req";

        try {
            String url = "jdbc:oracle:thin:@" + server + ":" + port + ":" + database;

            // Abre-se a conex�o com o Banco de Dados
            conn = DriverManager.getConnection(url, user, passwd);
        } catch (Exception e) {
			e.printStackTrace();
			System.out.print("Erro de conex�o com o banco de dados.");
		}
        return conn;
	}
	
	public void FecharConexao() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
