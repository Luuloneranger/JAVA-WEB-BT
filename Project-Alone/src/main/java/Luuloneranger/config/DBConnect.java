package Luuloneranger.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	private final String serverName = "LUULONERANGER";
	private final String dbName = "LapTrinhWeb_ChieuT3_Tuan2";
	private final String portNumber = "1433";
	private final String instance = "";
	private final String userID = "sa";
	private final String password = "luuluyen123";

	public Connection getConnection() throws Exception {
		String url = "jdbc:sqlserver://" + serverName + "\\" + instance + ":" + portNumber + ";databaseName=" + dbName 
				+ ";encrypt=true;trustServerCertificate=true";
		if (instance == null || instance.trim().isEmpty())
			url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName 
			+ ";encrypt=true;trustServerCertificate=true";
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(url, userID, password);
	}
}
