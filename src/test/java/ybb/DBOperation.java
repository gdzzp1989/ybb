package ybb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class DBOperation {
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://192.168.0.121:3306/wx_backend";
    public static final String USERNAME = "wxmysql";
    public static final String PASSWORD = "wxMysql@2019";

    public static Connection conn = null;
    public static PreparedStatement pstmt=null;

    public void init() throws Exception{
        Class.forName(DRIVER);
        conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }


    public void execSql(String sql) throws Exception{
        pstmt = conn.prepareStatement(sql);
        pstmt.executeUpdate(sql);
    }

    public void destory() throws Exception{
        pstmt.close();
        conn.close();
    }





}
