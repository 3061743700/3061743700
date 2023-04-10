package Utils;

import java.sql.*;

public class JdbcUtils {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("forName");
		}
	}

	public static Connection connection() {
		Connection conn = null;
		try {
			conn = ThreadUtils.getConn();
			if (conn==null){
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "20021124");
				ThreadUtils.setConn(conn);
			}
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("connection");
		}
		return conn;
	}

	public static void getClose(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("connection-getClose");
			}
		}
		if (preparedStatement != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("preparedStatement�ر��쳣");
			}
		}
		if (resultSet != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("resultSet�ر��쳣");
			}
		}
	}
}
