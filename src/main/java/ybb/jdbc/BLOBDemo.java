package ybb.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BLOBDemo {
	
	public static final String DRIVER="org.gjt.mm.mysql.Driver";
	public static final String URL="jdbc:mysql://localhost:3306/newsql";
	public static final String USERNAME="root";
	
	public static void main(String[] args) throws Exception {
		Connection conn=null;
		PreparedStatement  pstmt=null;
		ResultSet rs=null;
		
		Class.forName(DRIVER);
		conn=DriverManager.getConnection(URL,USERNAME,USERNAME);
		
		String sql="insert into newtable(name,photo) values(?,?)";
		pstmt=conn.prepareStatement(sql);
		
		File f=new File("d:"+File.separator+"test.gif");
		InputStream in=new FileInputStream(f);		
		pstmt.setString(1, "zzp");
		pstmt.setBinaryStream(2, in,(int)f.length());
		pstmt.executeUpdate();
		
		
	    sql="select name,photo from  newtable where name=?";
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, "zzp");
		rs=pstmt.executeQuery();
		if(rs.next()){
			String name=rs.getString(1);
			Blob blob=rs.getBlob(2);
			FileOutputStream out = new FileOutputStream(new File("d:"+File.separator+"test2.gif"));
			out.write(blob.getBytes(1, (int)blob.length()));
			out.close();
		}	
		pstmt.close();
		conn.close();
	}
}
