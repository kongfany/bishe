package com.example.mylogin.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.content.Context.MODE_PRIVATE;

public abstract class BaseFragment extends Fragment {

    protected View mRootView;
//    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView==null){
            mRootView=inflater.inflate(initLayout(),container,false);
            initView();
        }
//        unbinder= ButterKnife.bind(this,mRootView);
        return mRootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initDate();
    }

    protected abstract int initLayout();
    protected abstract void initView();
    protected abstract void initDate();

//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        unbinder.unbind();
//    }

    public void showToast(String msg) {//弹窗
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    public void showToastSyno(String msg) {//在子线程中弹窗
        Looper.prepare();
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
        Looper.loop();
    }

    public void navigateTo(Class cls){//跳转界面
        Intent in =new Intent(getActivity(),cls);
        startActivity(in);
    }

    protected void saveStringToSp(String key,String val){
        //token保存在本地，
        SharedPreferences sp=getActivity().getSharedPreferences("sp_ttit",MODE_PRIVATE);//xml文件的名称，模式私有的
        SharedPreferences.Editor editor=sp.edit();
        editor.putString(key,val);
        editor.commit();//token存放到sp_ttit.xml文件中
    }

    protected String getStringFromSp(String key){
        //从本地取出token
        SharedPreferences sp=getActivity().getSharedPreferences("sp_ttit",MODE_PRIVATE);
        return sp.getString(key,"");
    }
    protected String findByKey(String key) {
        SharedPreferences sp = getActivity().getSharedPreferences("sp_ttit", MODE_PRIVATE);
        return sp.getString(key, "");
    }
    protected void insertVal(String key, String val) {
        SharedPreferences sp = getActivity().getSharedPreferences("sp_ttit", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, val);
        editor.commit();
    }
}
