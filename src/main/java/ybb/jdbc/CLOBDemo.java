package ybb.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CLOBDemo {

	public static final String DRIVER="org.gjt.mm.mysql.Driver";
	public static final String URL="jdbc:mysql://localhost:3306/newsql";
	public static final String USERNAME="root";
	
	public static void main(String[] args) throws Exception {
		Connection conn=null;
		PreparedStatement  pstmt=null;
		ResultSet rs=null;
		
		Class.forName(DRIVER);
		conn=DriverManager.getConnection(URL,USERNAME,USERNAME);
		
		String sql="insert into newtable(name,note) values(?,?)";
		pstmt=conn.prepareStatement(sql);
		
		File f=new File("d:"+File.separator+"test.txt");
		InputStream in=new FileInputStream(f);		
		pstmt.setString(1, "zzp");
		pstmt.setAsciiStream(2, in,(int)f.length());
		pstmt.executeUpdate();
		
		
	    sql="select name,note from  newtable where name=?";
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, "zzp");
		rs=pstmt.executeQuery();
		if(rs.next()){
			String name=rs.getString(1);
			Clob clob=rs.getClob(2);
			String note=clob.getSubString(1, (int)clob.length());
			System.out.println(name+"   "+note);
		}	
		pstmt.close();
		conn.close();
	}
}
