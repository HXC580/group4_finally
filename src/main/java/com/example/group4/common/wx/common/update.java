package com.example.group4.common.wx.common;

import com.example.group4.common.wx.util.MSSQLUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class update {
    private static String user = "group4";
    private static String pwd = "CJMcjm136466!";
    private static String url = "jdbc:mysql://test-group4.mysql.rds.aliyuncs.com:9988/group4_3?useunicode=true;&characterEncoding=utf8";
    private static String   sql;

    static Connection conn=null;
    static PreparedStatement pstmt=null;
    public  static  void updateData(String id,String returncode){
        sql="UPDATE group4_3.po SET PO_STATE='"+ returncode+"' where PO_NO = '"+id+"';" ;


        MSSQLUtil.setPoState(returncode);
        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            conn = DriverManager.getConnection(url, user, pwd);
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
        }catch (SQLException e) {
            System.out.println("UPDATE ERROR!!!!!!!!!!!!!!");

            throw new RuntimeException(e);
        }



    }
}
