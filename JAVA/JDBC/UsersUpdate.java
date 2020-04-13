package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class UsersUpdate {

	public static void main(String[] args) {
		String sql = "update users set name=? ,  gender=?, city=? where userid=?";
		
		//1.
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String pass = "tiger";
		
		try {
			con = DriverManager.getConnection(url, user, pass);
			stmt = con.prepareStatement(sql);
			stmt.setString(1, "길네길동");
			stmt.setString(2, "여");
			stmt.setString(3, "경기도");
			stmt.setString(4, "gildong");
			
			int cnt = stmt.executeUpdate();
			System.out.println("갱신된 건수 " + cnt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
	}

}
