package vn.iotstar.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DBContext {
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

//	public static void main(String[] args) {
//		try {
//			Connection conn = new DBContext().getConnection();
//			Statement stmt =conn.createStatement();
//			
////			ResultSet rs = stmt.executeQuery("Select * From [User]");
//			
////			while (rs.next()) {
////				System.out.println(rs.getInt("id") + " " + rs.getString("name")+ " " + rs.getString("diachi"));
////			}
////			conn.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//	}
	
	
}
