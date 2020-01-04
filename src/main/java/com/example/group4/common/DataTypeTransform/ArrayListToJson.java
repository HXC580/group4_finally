package com.example.group4.common.DataTypeTransform;

import org.json.JSONArray;

import java.util.ArrayList;


public class ArrayListToJson {
    public static JSONArray listToJson(ArrayList<String> list){
        JSONArray jsonObject;
              jsonObject=new JSONArray( list);
        return jsonObject;

    }
}
