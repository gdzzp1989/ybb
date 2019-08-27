package ybb.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class CallableStatementDemo {
	/*create procedure myproc(IN p1 int, INOUT p2 int ,OUT p3 int)
	begin
	 select p1,p2,p3 ;
	 set p1=10;
	 set p2=20;
	 set p3=30;
	end */
	
	public static final String DRIVER="org.gjt.mm.mysql.Driver";
	public static final String URL="jdbc:mysql://localhost:3306/newsql";
	public static final String USERNAME="root";
	
	public static void main(String[] args) throws Exception {
		Connection conn=null;
		CallableStatement  cstmt=null;
		
		Class.forName(DRIVER);
		conn=DriverManager.getConnection(URL,USERNAME,USERNAME);
		
		String sql="{call myproc(?,?,?)}";
	    cstmt=conn.prepareCall(sql);
		cstmt.setInt(1,70);
		cstmt.setInt(2,80);
		cstmt.registerOutParameter(2,Types.INTEGER);      //设置返回值类型
		cstmt.registerOutParameter(3,Types.INTEGER);
		cstmt.execute();
		
		cstmt.close();
		conn.close();
	}
}
