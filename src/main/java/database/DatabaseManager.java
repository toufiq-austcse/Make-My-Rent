package database;
import java.sql.*;
public class DatabaseManager {
	public static Connection GetConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/make_my_rent?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return connection;
	}
}
