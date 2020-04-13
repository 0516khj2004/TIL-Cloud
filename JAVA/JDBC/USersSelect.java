package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.user.vo.UserVO;

public class USersSelect {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Driver loading");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String pass = "tiger";
		
		String sql = "select * from users";
		
		try {//2. connection
			con =DriverManager.getConnection(url,user,pass);
			System.out.println("Connection" + con);
			//3.statement 积己
			stmt = con.createStatement();
			System.out.println(stmt);
			//4.孽府 角青 - executeQuery() 
			rs= stmt.executeQuery(sql);
			System.out.println(rs);
			//5.孽府 搬苞 蔼 贸府
			UserVO uservo = null;
			List<UserVO> userlist = new ArrayList<>();
			
			while(rs.next()){
				String id = rs.getString("userid");
				String name = rs.getString("name");
				char gender = rs.getString("gender").charAt(0);
				String city = rs.getString("city");
				//UserVo 按眉 历厘
				uservo = new UserVO(id, name, gender, city);
				//userVo 按眉甫 ArrayList俊 历厘
				userlist.add(uservo);
			}
			for (UserVO userVO2 : userlist) {
				System.out.println(userVO2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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
