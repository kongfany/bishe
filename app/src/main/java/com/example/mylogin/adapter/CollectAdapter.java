package com.example.mylogin.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mylogin.R;
import com.example.mylogin.api.Api;
import com.example.mylogin.api.ApiConfig;
import com.example.mylogin.api.TtitCallback;
import com.example.mylogin.entity.CollectResponse;
import com.example.mylogin.entity.VideoEntity;

import java.util.HashMap;
import java.util.List;

public class CollectAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<VideoEntity> datas;     //本地模拟测试的数据

    public CollectAdapter(Context context, List<VideoEntity>  datas){//构造器
        this.mContext=context;
        this.datas=  datas;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.item_collect_layout,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //获取布局
        VideoEntity videoEntity=datas.get(position);
        //给布局渲染数据
        CollectAdapter.ViewHolder vh = (CollectAdapter.ViewHolder) holder;
        vh.name.setText(videoEntity.getName());
        vh.sponsor.setText(videoEntity.getSponsor());
        vh.time.setText(videoEntity.getTime());
        vh.introduce.setText(videoEntity.getIntroduce());
        vh.mPosition=position;

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        //控件对象就是viewhodle的成员属性
        //当前列表有多少项
        private TextView name;
        private TextView sponsor;
        private TextView time;
        private TextView introduce;
        private int mPosition;



        public ViewHolder(@NonNull View view) {
            super(view);
            //给控件赋值
            name = view.findViewById(R.id.ev_name);
            sponsor = view.findViewById(R.id.ev_sponsor);
            time = view.findViewById(R.id.ev_time);
            introduce = view.findViewById(R.id.ev_introduce);
        }

    }
}
