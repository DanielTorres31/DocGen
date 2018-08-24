package Connection;

import java.sql.*;

public class connectDB {
	
	static Connection conn = null;

	public static Connection CriarConexao() {

		// Configuração dos parâmetros de conexão
        String server = "192.168.0.41";
        String port = "1521";  // Porta TCP padrão do Oracle
        String database = "uganda.nosmoke";

        // Configuração dos parâmetros de autenticação
        String user = "req";
        String passwd = "req";

        try {
            String url = "jdbc:oracle:thin:@" + server + ":" + port + ":" + database;

            // Abre-se a conexão com o Banco de Dados
            conn = DriverManager.getConnection(url, user, passwd);
        } catch (Exception e) {
			e.printStackTrace();
			System.out.print("Erro de conexão com o banco de dados.");
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
