package com.example.mylogin.fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mylogin.R;
import com.example.mylogin.activity.LoginActivity;
import com.example.mylogin.adapter.NewsAdapter;
import com.example.mylogin.adapter.VideoAdapter;
import com.example.mylogin.api.Api;
import com.example.mylogin.api.ApiConfig;
import com.example.mylogin.api.TtitCallback;
import com.example.mylogin.entity.NewsEntity;
import com.example.mylogin.entity.NewsListResponse;
import com.example.mylogin.entity.VideoEntity;
import com.example.mylogin.entity.VideoListResponse;
import com.example.mylogin.util.StringUtils;
import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.api.RefreshLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VideoFragment extends BaseFragment {

    private String title;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    public VideoFragment() {
        // Required empty public constructor
    }

    public static VideoFragment newInstance(String title) {
        VideoFragment fragment = new VideoFragment();
        fragment.title=title;
        return fragment;
    }

    protected int initLayout() {
        return R.layout.fragment_video;
    }

    @Override
    protected void initView() {
        recyclerView=mRootView.findViewById(R.id.recyclerView);//得到recycleview控件
    }

    @Override
    protected void initDate() {
        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //给recycleView设置布局管理器，线性布局
        recyclerView.setLayoutManager(linearLayoutManager);

        getVideoList();
    }

    //通过接口获得videolist视频列表
    private void getVideoList(){
        HashMap<String, Object> params = new HashMap<String, Object>();
        Api.config(ApiConfig.Huodong_LIST, params).getRequest(new TtitCallback() {
            @Override
            public void onSuccess(final String res) {
                Log.e("onSuccess",res);
//                showToastSyno(res);
                VideoListResponse response = new Gson().fromJson(res, VideoListResponse.class);
                if (response != null && response.getCode() == 0) {
                    List<VideoEntity> datas = response.getData();
                    final VideoAdapter videoAdapter = new VideoAdapter(getActivity(), datas);//datas传入到videofragment中来
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            recyclerView.setAdapter(videoAdapter);//将数据渲染的每一个item布局上去
                        }
                    });
                }
            }
            @Override
            public void onFailure(Exception e) {
            }
        });

    }
}
