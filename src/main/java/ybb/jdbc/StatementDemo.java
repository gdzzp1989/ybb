package ybb.jdbc;

import java.sql.*;

public class StatementDemo {

	//public static final String DRIVER="oracle.jdbc.driver.OracleDrive";
	//public static final String DRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static final String DRIVER="com.mysql.cj.jdbc.Driver";
	public static final String URL="jdbc:mysql://192.168.0.120:3306/wx_backend?characterEncoding=utf8&useSSL=false&autoReconnect=true&failOverReadOnly=false&serverTimezone=Asia/Shanghai";
	public static final String USERNAME="wxmysql";
	public static final String PASSWORD="wxMysql@2019";

	public static void main(String[] args) throws Exception {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Statement stmt = null;
		try {
			Class.forName(DRIVER);
			//DriverManager.deregisterDriver(DriverManager.getDrivers().nextElement());
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			String sql = " select * from com_school_book_data where questionnaire_school_id=1594607971 and type=24 ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			while (rs.next()) {
				String classz = rs.getString("class");
				String content = rs.getString("content");
			}
		}catch(Exception e){

		}finally{
			rs.close();
			pstmt.close();
			conn.close();
		}



	}


}
