package com.example.group4.common.getData;



import com.example.group4.common.DataTypeTransform.MapToJSON;
import com.example.group4.common.DataTypeTransform.getDataMap;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class getDataFromMysql {
    private static String user = "group4";
    private static String pwd = "CJMcjm136466!";
    private static String url = "jdbc:mysql://test-group4.mysql.rds.aliyuncs.com:9988/group4_3?useunicode=true;&characterEncoding=utf8";
    private static Connection conn=null;
    private static ResultSet rs = null;
    private static PreparedStatement pstmt=null;

    public static ArrayList<String> getConnerct(String sql ){
        String result = null;
        ArrayList<String> list=new ArrayList<>();//写！！！在！！！里面一定要！！！每次！！！都清空

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
            rs = pstmt.executeQuery();

            while (rs.next())
            {
                result= MapToJSON.mapToJson( (HashMap<String, String>) getDataMap.getResultMap(rs)).toString();
                list.add(result);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//        finally{
//            // 最后是用于关闭资源的块
//            try{
//                if(pstmt!=null)
//                    pstmt.close();
//            }catch(SQLException se2){
//            }
//            try{
//                if(conn!=null)
//                    conn.close();
//            }catch(SQLException se){
//                se.printStackTrace();
//            }
//        }
        System.out.println("getConnerct:   "+list);
        return list;
    }

    public static ArrayList<HashMap> getDataArrayListMap(String sql ){

        ArrayList<HashMap> list=new ArrayList<>();//写！！！在！！！里面一定要！！！每次！！！都清空

        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            conn = DriverManager.getConnection(url, user, pwd);
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next())
            {
                HashMap map=(HashMap<String, String>) getDataMap.getResultMap(rs);
                list.add(map);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//        finally{
//            // 最后是用于关闭资源的块
//            try{
//                if(pstmt!=null)
//                    pstmt.close();
//            }catch(SQLException se2){
//            }
//            try{
//                if(conn!=null)
//                    conn.close();
//            }catch(SQLException se){
//                se.printStackTrace();
//            }
//        }
        System.out.println("getDataArrayListMap:   "+list);
        return list;
    }

    public static ArrayList<String> getOnecolumnDataNoMap(String sql,String column){
        String result = null;
        ArrayList<String> list=new ArrayList<>();//写！！！在！！！里面一定要！！！每次！！！都清空
        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            conn = DriverManager.getConnection(url, user, pwd);
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next())
            {
                result=rs.getString(column);
                list.add(result);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//
//        finally{
//            // 最后是用于关闭资源的块
//            try{
//                if(pstmt!=null)
//                    pstmt.close();
//            }catch(SQLException se2){
//            }
//            try{
//                if(conn!=null)
//                    conn.close();
//            }catch(SQLException se){
//                se.printStackTrace();
//            }
//        }
        System.out.println("getOnecolumnDataNoMap:  "+list);
        return list;
    }
}
