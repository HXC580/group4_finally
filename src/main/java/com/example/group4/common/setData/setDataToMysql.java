package com.example.group4.common.setData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class setDataToMysql {
    private static String user = "group4";
    private static String pwd = "CJMcjm136466!";
    private static String url = "jdbc:mysql://test-group4.mysql.rds.aliyuncs.com:9988/group4_3?useunicode=true;&characterEncoding=utf8";
    private static Connection conn=null;
    private static PreparedStatement pstmt=null;

    public static void InsertOrUpdateDataToMysql(String sql){
        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {

            conn = DriverManager.getConnection(url, user, pwd);
            pstmt = conn.prepareStatement(sql);
            pstmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            // 最后是用于关闭资源的块
            try{
                if(pstmt!=null)
                    pstmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }
}
