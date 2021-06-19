package com.example.mylogin.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.mylogin.R;
import com.example.mylogin.adapter.HomeAdapter;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;


public class EventFragment extends Fragment {
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private final String[] mTitles={
            "热门","团日活动","校园文化",
            "学术讲座","志愿活动","技能培训"
    };
    private ViewPager viewPager;    //两个控件对象
    private SlidingTabLayout slidingTabLayout;
    private EditText search;
    public EventFragment() {
        // Required empty public constructor
    }


    public static EventFragment newInstance() {
        EventFragment fragment = new EventFragment();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_event, container, false);
        viewPager = v.findViewById(R.id.fixedViewPager);//获取两个控件对象
        slidingTabLayout = v.findViewById(R.id.slidingTabLayout);
        search=v.findViewById(R.id.et_search);
        return v;
    }


    //数据的处理
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        for (String title:mTitles){
            mFragments.add(VideoFragment.newInstance(title));
        }
        viewPager.setOffscreenPageLimit(mFragments.size());//设置预加载，默认预加载前后的界面，这里预加载所有的
        //绑定适配器,
        viewPager.setAdapter(new HomeAdapter(getFragmentManager(),mTitles,mFragments));
        //使得两个联动
        slidingTabLayout.setViewPager(viewPager);

    }

}