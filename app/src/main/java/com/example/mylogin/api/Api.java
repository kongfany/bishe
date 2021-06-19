package com.example.mylogin.api;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.mylogin.activity.LoginActivity;
import com.example.mylogin.util.StringUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static android.content.Context.MODE_PRIVATE;

/**
 * 封装请求的逻辑
 */
public class Api {
    private static OkHttpClient client;
    private static String reguestUrl;
    private static HashMap<String,Object>mParams;
    public static Api api=new Api();

    public Api(){

    }
    //通过config来传入方法
    public static Api config(String url, HashMap<String,Object>params){
        //第一步创建OKHttpClient
        client = new OkHttpClient.Builder()
                .build();
        reguestUrl=ApiConfig.BASE_URl+url;
        mParams =params;
        return api;
    }
    //post请求,传入写好的回调接口
    //将登陆接口封装到postrequest中来了
    public static void postRequest(final TtitCallback callback){

        JSONObject jsonObject = new JSONObject(mParams);
        String jsonStr = jsonObject.toString();
        //创建请求体
        RequestBody requestBodyJson =
                RequestBody.create(MediaType.parse("application/json;charset=utf-8")
                        , jsonStr);
        //第三步创建Rquest
        Request request = new Request.Builder()
                .url(reguestUrl)
                .addHeader("contentType", "application/json;charset=UTF-8")
                .post(requestBodyJson)
                .build();
        //第四步创建call回调对象
        final Call call = client.newCall(request);
        //第五步发起请求
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("onFailure", e.getMessage());
                //请求失败
                callback.onFailure(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String result = response.body().string();

                //请求成功
                callback.onSuccess(result);

            }
        });
    }

    //get请求
    public void getRequest(  final TtitCallback callback) {

        String url = getAppendUrl(reguestUrl, mParams);

        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("onFailure", e.getMessage());
                callback.onFailure(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String result = response.body().string();
//                try {
//                    JSONObject jsonObject = new JSONObject(result);
//                    String code = jsonObject.getString("code");
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
                callback.onSuccess(result);
            }
        });
    }

    private String getAppendUrl(String url, Map<String, Object> map) {
        if (map != null && !map.isEmpty()) {
            StringBuffer buffer = new StringBuffer();
            Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Object> entry = iterator.next();
                if (StringUtils.isEmpty(buffer.toString())) {
                    buffer.append("?");
                } else {
                    buffer.append("&");
                }
                buffer.append(entry.getKey()).append("=").append(entry.getValue());
            }
            url += buffer.toString();
        }
        return url;
    }

    //put请求
    public static void putRequest(final TtitCallback callback){

        JSONObject jsonObject = new JSONObject(mParams);
        String jsonStr = jsonObject.toString();
        //创建请求体
        RequestBody requestBodyJson =
                RequestBody.create(MediaType.parse("application/json;charset=utf-8")
                        , jsonStr);
        //第三步创建Rquest
        Request request = new Request.Builder()
                .url(reguestUrl)
                .addHeader("contentType", "application/json;charset=UTF-8")
                .put(requestBodyJson)
                .build();
        //第四步创建call回调对象
        final Call call = client.newCall(request);
        //第五步发起请求
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("onFailure", e.getMessage());
                //请求失败
                callback.onFailure(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String result = response.body().string();
                //请求成功
                callback.onSuccess(result);

            }
        });
    }

    //delect请求
    public static void deleteRequest(final TtitCallback callback){

        JSONObject jsonObject = new JSONObject(mParams);
        String jsonStr = jsonObject.toString();
        //创建请求体
        RequestBody requestBodyJson =
                RequestBody.create(MediaType.parse("application/json;charset=utf-8")
                        , jsonStr);
        //第三步创建Rquest
        Request request = new Request.Builder()
                .url(reguestUrl)
                .addHeader("contentType", "application/json;charset=UTF-8")
                .delete()
                .build();
        //第四步创建call回调对象
        final Call call = client.newCall(request);
        //第五步发起请求
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("onFailure", e.getMessage());
                //请求失败
                callback.onFailure(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String result = response.body().string();
                //请求成功
                callback.onSuccess(result);

            }
        });
    }
}
