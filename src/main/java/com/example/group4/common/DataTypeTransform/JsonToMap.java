package com.example.group4.common.DataTypeTransform;

import net.sf.json.JSONObject;
import java.util.Map;


import java.util.Map;

public class JsonToMap {
public static Map<String,String> transfrom(String json){//json转MAP
    JSONObject jsonObject = JSONObject.fromObject(json);
    Map<String, String> map = (Map)jsonObject;
    return map;

}
}
