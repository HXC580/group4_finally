package com.example.group4.common.DataTypeTransform;

import java.util.ArrayList;

public class jsontouwei {

    public static String jsontw(ArrayList<String> list){
        String STR="";
        String string="";
            for(int i=0;i<list.size();i++){

                if(i==list.size()-1&&list.size()!=1)//长度不为1的头替换
                     {
                    string=list.get(i).replace("}","}]");
                    System.out.println("wei");
                }
                 else if (i==0&& list.size()!=1)//长度不为1的尾替换
                 {
                    string=list.get(i).replace("{","[{").replace("}","},");
                    System.out.println("tou");
                }
                 else if(list.size()==1)//长度为一的头尾替换
                 {
                    string=list.get(i).replace("}","}]").replace("{","[{");
                    System.out.println("长度为一");
                }

                else//长度不为一的，中间替换
                    {
                    string=list.get(i).replace("}","},");
                }
                STR+=string;
            }

        return STR;
}}
