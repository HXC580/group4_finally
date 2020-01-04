package com.example.group4.common.DataTypeTransform;

import java.util.ArrayList;

public class getlistlist {
    private  static ArrayList<String> arrayList=new ArrayList<>();
    public static void setlist(String str){
        arrayList.add(str);
    }
    public static String getlistTOjson(){
        String str="";
        for(int a=0;a<arrayList.size();a++){
            if(a<arrayList.size()-1){
                str+=arrayList.get(a)+",";
            }
            else {
                str+=arrayList.get(a);
            }
        }
        return str;
    }
}
