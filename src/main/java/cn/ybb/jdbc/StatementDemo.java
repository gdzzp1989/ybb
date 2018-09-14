package cn.ybb.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class StatementDemo {
	
	//public static final String DRIVER="oracle.jdbc.driver.OracleDrive";
	//public static final String DRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static final String DRIVER="org.gjt.mm.mysql.Driver";
	public static final String URL="jdbc:mysql://localhost:3306/newsql";
	public static final String USERNAME="root";
	
	public static void main(String[] args) throws Exception {
		Connection conn=null;
		Statement stmt=null;
		PreparedStatement  pstmt=null;
		
		Class.forName(DRIVER);
		conn=DriverManager.getConnection(URL,USERNAME,USERNAME);
		
		String sql="insert into newtable(name) values('zzp')";	
		stmt=conn.createStatement();
		stmt.executeUpdate(sql);
		
		String sql2="insert into newtable(name) values(?)";
		pstmt=conn.prepareStatement(sql2);
		pstmt.setString(1, "zzp");
		pstmt.executeUpdate();	
		
		
		stmt.close();
		pstmt.close();
		conn.close();
	}
}