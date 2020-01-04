package com.example.group4.common.isNull;



import com.example.group4.common.getData.getDataFromMysql;

import java.util.HashMap;
import java.util.Iterator;

public class  isNull {
    public static Boolean isOrNull(String sql){
        sql="select isnull("+sql+")";
        HashMap map= getDataFromMysql.getDataArrayListMap(sql).get(0);
        String str="";
        Iterator<String> iter = map.keySet().iterator();
        while(iter.hasNext()){
            String key=iter.next();
            String value = map.get(key).toString();
            System.out.println(key+"    "+value);
            str=value;
        }
        if(str.equals("0")){
            return true;
        }else if (str.equals("1")){
             return false;
        }else {
            return false;
        }
    }
}
