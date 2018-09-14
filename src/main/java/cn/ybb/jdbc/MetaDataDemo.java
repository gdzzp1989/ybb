package cn.ybb.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class MetaDataDemo {
	
	public static final String DRIVER="org.gjt.mm.mysql.Driver";
	public static final String URL="jdbc:mysql://localhost:3306/newsql";
	public static final String USERNAME="root";
	
	public static void main(String[] args) throws Exception {
		Connection conn=null;
		ResultSet rs=null;
		
		Class.forName(DRIVER);
		conn=DriverManager.getConnection(URL,USERNAME,USERNAME);
		DatabaseMetaData dmd=conn.getMetaData(); 
		System.out.println("数据库名称:"+dmd.getDatabaseProductName());
		System.out.println("数据库版本:"+dmd.getDriverMinorVersion()+"."+dmd.getDatabaseMajorVersion());
	
		rs=dmd.getPrimaryKeys(null, null, "user");
		while(rs.next()){
			System.out.println("表名称:"+rs.getString(3));
			System.out.println("列名称:"+rs.getString(4));		
		}
		conn.close();
	}

}
