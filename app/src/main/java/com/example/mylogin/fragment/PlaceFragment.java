package com.example.mylogin.fragment;

import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mylogin.R;
import com.example.mylogin.activity.LoginActivity;
import com.example.mylogin.activity.NavigationActivity;
import com.example.mylogin.api.Api;
import com.example.mylogin.api.ApiConfig;
import com.example.mylogin.api.TtitCallback;

import java.util.HashMap;


public class PlaceFragment extends BaseFragment {

    private Button btn;


    public static PlaceFragment newInstance() {
        PlaceFragment fragment = new PlaceFragment();
        return fragment;
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_place;
    }

    @Override
    protected void initView() {
        btn=mRootView.findViewById(R.id.btn_navigation);
    }

    @Override
    protected void initDate() {

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateTo(NavigationActivity.class);
            }
        });
    }
}
