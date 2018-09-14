package cn.ybb.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ResultSetDemo {
	public static final String DRIVER="org.gjt.mm.mysql.Driver";
	public static final String URL="jdbc:mysql://localhost:3306/newsql";
	public static final String USERNAME="root";
	
	public static void main(String[] args) throws Exception {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		Class.forName(DRIVER);
		conn=DriverManager.getConnection(URL,USERNAME,USERNAME);
		
		String sql="select name from newtable where name like ? ";		
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(0, "zzp");
		rs=pstmt.executeQuery(sql);
		
		while(rs.next()){
			int id=rs.getInt("id");          //int id=rSet.getInt(1);
			String name=rs.getString("name");//String name=rSet.getString(2);
			String sex=rs.getString("sex"); 
			System.out.println(id+name+sex);	
		}
		
		rs.close();
		pstmt.close();
		conn.close();
	}
}
