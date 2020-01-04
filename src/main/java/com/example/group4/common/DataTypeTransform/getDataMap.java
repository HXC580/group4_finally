package com.example.group4.common.DataTypeTransform;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class getDataMap {
    public static Map<String, String> getResultMap(ResultSet rs)
            throws SQLException {
        Map<String, String> hm = new HashMap<String, String>();
        ResultSetMetaData rsmd = rs.getMetaData();
        int count = rsmd.getColumnCount();
        for (int i = 1; i <= count; i++) {
            String key = rsmd.getColumnLabel(i);
            String value;
            if (key.equals("id")){
                 value=rs.getInt(i)+"";
            }else {
                 value = rs.getString(i);
            }
           hm.put(key, value);
        }return hm;
    }
}
