package com.example.mylogin.util;

import com.google.gson.Gson;

import java.lang.reflect.Type;

public class StringUtils {//将一些方法封装在这个工具类中
    public static boolean isEmpty(String str){//把判断为空封装到一个方法中去了
        if(str==null||str.length()<=0){
            return true;
        }else{
            return false;
        }
    }
    //根据泛型返回解析制定的类型
    public static <T> T fromToJson(String json, Type listType){
        Gson gson = new Gson();
        T t = null;
        t = gson.fromJson(json,listType);
        return t;
    }

}
