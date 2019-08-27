package ybb.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class BatchDemo {
	
	public static final String DRIVER="org.gjt.mm.mysql.Driver";
	public static final String URL="jdbc:mysql://localhost:3306/newsql";
	public static final String USERNAME="root";
	
	public static void main(String[] args) throws Exception {
		Connection conn=null;
		PreparedStatement  pstmt=null;
		
		Class.forName(DRIVER);
		conn=DriverManager.getConnection(URL,USERNAME,USERNAME);
		conn.setAutoCommit(false);
		String sql="insert into newtable(name) values(?)";
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, "zzp1");
		pstmt.addBatch();
		
		pstmt.setString(1, "zzp2");
		pstmt.addBatch();
		
		pstmt.addBatch("insert into newtable(name) values('zzp3')");
		
		int temp[]=pstmt.executeBatch();	

		System.out.println("更新数据数:"+temp.length);
		
		conn.commit();
		pstmt.close();
		conn.close();
	}
}
