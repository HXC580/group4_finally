package com.example.group4.common.DataTypeTransform;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GetKeyOrValueFromMap {
    public static ArrayList<String> getValue(HashMap<String,String> map){
        ArrayList<String> valueList=new ArrayList<>();
        Iterator<String> iter = map.keySet().iterator();
        while(iter.hasNext()){
            String key=iter.next();
            valueList.add( map.get(key));
            }
        return valueList;
    }
    public static ArrayList<String> getKey(HashMap<String,String> map){
        ArrayList<String> keyList=new ArrayList<>();
        Iterator<String> iter = map.keySet().iterator();
        while(iter.hasNext()){
            String key=iter.next();
            keyList.add( key);
        }
        return keyList;
    }
    public static ArrayList<String> getElement(HashMap<String,String> map,String column){
        ArrayList<String> ElementList=new ArrayList<>();
        Iterator<String> iter = map.keySet().iterator();
        while(iter.hasNext()){
            String key=iter.next();
            if(key.trim().equals(column)){
                ElementList.add( map.get(key));
            }
        }
        return ElementList;
    }
}
