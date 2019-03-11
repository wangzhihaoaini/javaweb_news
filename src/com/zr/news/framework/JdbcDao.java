package com.zr.news.framework;
  import java.sql.DriverManager;
  import java.sql.SQLException;
  import java.sql.Connection;
public class JdbcDao {
    private static String driveClassName="com.mysql.jdbc.Driver";
    private static String url="jdbc:mysql://localhost:3306/newsdb";
    private static String user="root";
    private static String password="wzh123456...";
    private static Connection conn;

    public static Connection getConnection(){
        try {
            Class.forName(driveClassName);
            conn=DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeConnection(){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
