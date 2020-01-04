package com.example.group4.common.DataTypeTransform;

import org.json.JSONObject;

import java.util.HashMap;

public class MapToJSON {
    public static JSONObject mapToJson(HashMap<String,String> map){
        JSONObject jsonObject=new JSONObject();
        jsonObject=new JSONObject(map);
        return jsonObject;

    }
}
