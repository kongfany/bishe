package com.example.mylogin.fragment;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mylogin.R;
import com.example.mylogin.adapter.NewsAdapter;
import com.example.mylogin.adapter.SchoolAdapter;
import com.example.mylogin.adapter.VideoAdapter;
import com.example.mylogin.api.Api;
import com.example.mylogin.api.ApiConfig;
import com.example.mylogin.api.TtitCallback;
import com.example.mylogin.entity.NewsEntity;
import com.example.mylogin.entity.NewsListResponse;
import com.example.mylogin.entity.SchoolEntity;
import com.example.mylogin.entity.SchoolListResponse;
import com.example.mylogin.entity.VideoEntity;
import com.example.mylogin.entity.VideoListResponse;
import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.api.RefreshLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NewsFragment extends BaseFragment {

    private RecyclerView recyclerView;
    private RefreshLayout refreshLayout;//分页
    private NewsAdapter newsAdapter;
    private List<NewsEntity> datas = new ArrayList<>();
    private LinearLayoutManager linearLayoutManager;

    private Spinner spinner;
    boolean spinner_selected=false;
    private static int TRAVEL_MODE = 0;

    public NewsFragment() {
    }


    public static NewsFragment newInstance() {
        NewsFragment fragment = new NewsFragment();
        return fragment;
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_news;
    }

    @Override
    protected void initView() {
        recyclerView = mRootView.findViewById(R.id.recyclerView);
        refreshLayout = mRootView.findViewById(R.id.refreshLayout);
    }

    @Override
    protected void initDate() {
        bindViews();
        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //给recycleView设置布局管理器，线性布局
        recyclerView.setLayoutManager(linearLayoutManager);
        getSchoolList();
    }

    private void getNewsList() {
        HashMap<String, Object> params = new HashMap<String, Object>();
        Api.config(ApiConfig.Jingdian_LIST, params).getRequest(new TtitCallback() {
            @Override
            public void onSuccess(final String res) {
                Log.e("onSuccess",res);
//                showToastSyno(res);
                NewsListResponse response = new Gson().fromJson(res, NewsListResponse.class);
                if (response != null && response.getCode() == 0) {
                    List<NewsEntity> datas = response.getData();
                    final NewsAdapter newsAdapter = new NewsAdapter(getActivity(), datas);//datas传入到videofragment中来

                    //主线程渲染布局
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            recyclerView.setAdapter(newsAdapter);//将数据渲染的每一个item布局上去
                        }
                    });
                }
            }
            @Override
            public void onFailure(Exception e) {
            }
        });
    }
    private void getSchoolList(){
        HashMap<String, Object> params = new HashMap<String, Object>();
        Api.config(ApiConfig.School_LIST, params).getRequest(new TtitCallback() {
            @Override
            public void onSuccess(final String res) {
                Log.e("onSuccess",res);
                SchoolListResponse response = new Gson().fromJson(res, SchoolListResponse.class);
                if (response != null && response.getCode() == 0) {
                    List<SchoolEntity> datas = response.getData();
                    final SchoolAdapter schoolAdapter = new SchoolAdapter(getActivity(),datas);//datas传入到videofragment中来
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            recyclerView.setAdapter(schoolAdapter);//将数据渲染的每一个item布局上去
                        }
                    });
                }
            }
            @Override
            public void onFailure(Exception e) {
            }
        });

    }
    private void bindViews(){
        spinner=mRootView.findViewById(R.id.jd_spinner);
        //添加事件Spinner事件监听
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (spinner_selected){
                    TRAVEL_MODE = position;
                    changeScenery();
                }
                else{
                    spinner_selected=true;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
    private void changeScenery(){
        switch (TRAVEL_MODE){
            case 0://校内景点
                getSchoolList();
                showToast("校内景点");
                break;
            case 1://周边景点
                getNewsList();
                showToast("周边景点");
                break;
        }
    }
}
