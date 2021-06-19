package com.example.mylogin.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.os.PersistableBundle;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.app.SkinAppCompatDelegateImpl;


public  abstract class BaseActivity extends AppCompatActivity {//重复代码放在基类里

    public Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(initLayout());
        initView();
        initDate();

    }
    protected abstract int initLayout();
    protected abstract void initView();
    protected abstract void initDate();

    public void showToast(String msg) {//弹窗
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    public void showToastSyno(String msg) {//在子线程中弹窗
        Looper.prepare();
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
        Looper.loop();
    }

    public void navigateTo(Class cls){//跳转界面
        Intent in =new Intent(mContext,cls);
        startActivity(in);
    }

    protected void saveStringToSp(String key,String val){
        //保存在本地，
        SharedPreferences sp=getSharedPreferences("sp_ttit",MODE_PRIVATE);//xml文件的名称，模式私有的
        SharedPreferences.Editor editor=sp.edit();
        editor.putString(key,val);
        editor.commit();
    }

    protected String getStringFromSp(String key){
        //从本地取出
        SharedPreferences sp=getSharedPreferences("sp_ttit",MODE_PRIVATE);
        return sp.getString(key,"");
    }

    @NonNull
    @Override
    public AppCompatDelegate getDelegate() {
        return SkinAppCompatDelegateImpl.get(this, this);
    }
}
