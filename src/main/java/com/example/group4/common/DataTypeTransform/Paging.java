package com.example.group4.common.DataTypeTransform;


import com.example.group4.common.getData.getDataFromMysql;

import java.util.ArrayList;
import java.util.HashMap;

public class Paging {


    public static ArrayList<ArrayList<String>> getPageByArrayList(int n,ArrayList arrayList){//Device页面上的分页函数
        //n:一页多少个
        ArrayList<ArrayList<String>>  lingshi2=new ArrayList();
        ArrayList<String>  lingshi=new ArrayList();
        System.out.println(arrayList);
        int size=arrayList.size();
        int i=size/n+1;
        if(size%n==0){
            i=size/n;
        }
        System.out.println("getPageByArrayList_i:"+i);

        if(i>=2){
           for (int j=0;j<i;j++){
               for (int k=0;k<n;k++)
               {
                   if(n * j + k < size) {
                       lingshi.add(arrayList.get(n * j + k).toString());
               }
               }
               lingshi2.add(lingshi);
               lingshi = new ArrayList();
           }
       }else
       {
           for(int j=0;j<size;j++){
               lingshi.add(arrayList.get(j).toString());
           }
           lingshi2.add(lingshi);
           System.out.println(lingshi2);
       }
return lingshi2;
    }
    public static int getPageNumber(int nn,String sql){
        ArrayList<HashMap> arrayList = getDataFromMysql.getDataArrayListMap(sql);

        int n = arrayList.size();
        if (n % nn == 0) {
            n = arrayList.size() / nn;
        } else {
            n = arrayList.size() / nn + 1;
        }
    return n;
    }
}
