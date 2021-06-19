package com.example.mylogin.api;

public interface TtitCallback {
    void onSuccess(String res);//请求成功的回调

    void onFailure(Exception e);//请求失败的回调
}
