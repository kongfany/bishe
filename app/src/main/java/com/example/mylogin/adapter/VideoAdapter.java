package com.example.mylogin.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mylogin.R;
import com.example.mylogin.activity.CommentActivity;
import com.example.mylogin.api.Api;
import com.example.mylogin.api.ApiConfig;
import com.example.mylogin.api.TtitCallback;
import com.example.mylogin.entity.CollectEntity;
import com.example.mylogin.entity.CollectListResponse;
import com.example.mylogin.entity.NewsEntity;
import com.example.mylogin.entity.VideoEntity;
import com.example.mylogin.entity.VideoListResponse;
import com.google.gson.Gson;


import java.util.HashMap;
import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<VideoEntity>datas;     //本地模拟测试的数据
    private int urlid;

    public VideoAdapter(Context context, List<VideoEntity>datas){//构造器
        this.mContext=context;
        this.datas=datas;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.item_video_layout,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //获取布局
        VideoEntity videoEntity=datas.get(position);
        //给布局渲染数据
        VideoAdapter.ViewHolder vh = (VideoAdapter.ViewHolder) holder;
        vh.name.setText(videoEntity.getName());
        vh.sponsor.setText(videoEntity.getSponsor());
        vh.time.setText(videoEntity.getTime());
        vh.introduce.setText(videoEntity.getIntroduce());
        vh.tvComment.setText(String.valueOf(videoEntity.getCommentnum()));
        vh.tvCollect.setText(String.valueOf(videoEntity.getCollectnum()));
        vh.tvlike.setText(String.valueOf(videoEntity.getLikenum()));
        //收藏标志，int型
        vh.flagCollect=videoEntity.getFlagcollect();
        //int转boolean---0为false，1为true
        if (vh.flagCollect==0){
            vh.bflagCollect=false;
        }else{
            vh.bflagCollect=true;
        }
        vh.flagLike=videoEntity.getFlaglike();
        if (vh.flagLike==0){
            vh.bflagLike=false;
        }else{
            vh.bflagLike=true;
        }
        //初始情况判断
        if (vh.bflagCollect){
            vh.tvCollect.setTextColor(Color.parseColor("#E21918"));
            vh.imgCollect.setImageResource(R.mipmap.collect_select);
        }
        if (vh.bflagLike){
            vh.tvlike.setTextColor(Color.parseColor("#E21918"));
            vh.imgLike.setImageResource(R.mipmap.dianzan_select);
        }
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
        private TextView tvlike;
        private TextView tvComment;
        private TextView tvCollect;
        private ImageView imgCollect;
        private ImageView imgLike;
        private ImageView imgcomment;
        private int flagCollect;
        private boolean bflagCollect;
        private int flagLike;
        private boolean bflagLike;
        private int mPosition;
        private int collectnum;
        private int likenum;



        public ViewHolder(@NonNull View view) {
            super(view);
            //给控件赋值
            name=view.findViewById(R.id.ev_name);
            sponsor=view.findViewById(R.id.ev_sponsor);
            time=view.findViewById(R.id.ev_time);
            introduce=view.findViewById(R.id.ev_introduce);
            tvComment=view.findViewById(R.id.ev_comment);
            tvCollect=view.findViewById(R.id.ev_collect);
            tvlike=view.findViewById(R.id.ev_like);
            imgLike=view.findViewById(R.id.img_like);
            imgCollect=view.findViewById(R.id.img_collect);
            imgcomment=view.findViewById(R.id.img_comment);


            imgCollect.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    collectnum=Integer.parseInt(tvCollect.getText().toString());
                    likenum=Integer.parseInt(tvlike.getText().toString());
                    if (bflagCollect){//已经收藏,即取消点赞,flag=1
                        if (collectnum>0){
                            tvCollect.setText(String.valueOf(--collectnum));//数值减一
                            tvCollect.setTextColor(Color.parseColor("#161616"));//字体颜色恢复
                            imgCollect.setImageResource(R.mipmap.collect);//图片恢复
                            flagCollect--;//flag变为0,
                            updateCount(datas.get(mPosition).getId(),collectnum,flagCollect,
                                    likenum,flagLike,datas.get(mPosition).getCommentnum(),
                                    datas.get(mPosition).getName(),datas.get(mPosition).getTime(),datas.get(mPosition).getSponsor(),
                                    datas.get(mPosition).getIntroduce(),datas.get(mPosition).getTypeid());
                            int deleteeventid=datas.get(mPosition).getId();
                            deleteCollect(deleteeventid);

                        }
                    }else {//未收藏
                        tvCollect.setText(String.valueOf(++collectnum));
                        tvCollect.setTextColor(Color.parseColor("#E21918"));
                        imgCollect.setImageResource(R.mipmap.collect_select);
                        flagCollect++;
                        updateCount(datas.get(mPosition).getId(),collectnum,flagCollect,
                                likenum,flagLike,datas.get(mPosition).getCommentnum(),
                                datas.get(mPosition).getName(),datas.get(mPosition).getTime(),datas.get(mPosition).getSponsor(),
                                datas.get(mPosition).getIntroduce(),datas.get(mPosition).getTypeid());
                        int eventid=datas.get(mPosition).getId();
                        addCollect(eventid);
                    }
                    Log.e("收藏flag", String.valueOf(flagCollect));
                    bflagCollect=!bflagCollect;
                }
            });

            imgLike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    collectnum=Integer.parseInt(tvCollect.getText().toString());
                    likenum=Integer.parseInt(tvlike.getText().toString());
                    if (bflagLike){//已经dianz
                        if (likenum>0){
                            tvlike.setText(String.valueOf(--likenum));
                            tvlike.setTextColor(Color.parseColor("#161616"));
                            imgLike.setImageResource(R.mipmap.dianzan);
                            flagLike--;
                            updateCount(datas.get(mPosition).getId(),collectnum,flagCollect,
                                    likenum,flagLike,datas.get(mPosition).getCommentnum(),
                                    datas.get(mPosition).getName(),datas.get(mPosition).getTime(),datas.get(mPosition).getSponsor(),
                                    datas.get(mPosition).getIntroduce(),datas.get(mPosition).getTypeid());
                        }
                    }else {//未dianz
                        tvlike.setText(String.valueOf(++likenum));
                        tvlike.setTextColor(Color.parseColor("#E21918"));
                        imgLike.setImageResource(R.mipmap.dianzan_select);
                        flagLike++;
                        updateCount(datas.get(mPosition).getId(),collectnum,flagCollect,
                                likenum,flagLike,datas.get(mPosition).getCommentnum(),
                                datas.get(mPosition).getName(),datas.get(mPosition).getTime(),datas.get(mPosition).getSponsor(),
                                datas.get(mPosition).getIntroduce(),datas.get(mPosition).getTypeid());
                    }
                    bflagLike=!bflagLike;
                    Log.e("喜欢flag", String.valueOf(flagLike));
                }
            });

            imgcomment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in =new Intent(mContext, CommentActivity.class);
                    mContext.startActivity(in);
                }
            });


        }


        private void updateCount(int id,int collectnum,int flagcollect,int likenum,int flaglike,int commentnum,String name,String time,String sponsor,String introduce,int typeid){
            HashMap<String, Object> params = new HashMap<String, Object>();//jianzhi
            params.put("id", id);
            params.put("collectnum", collectnum);
            params.put("flagcollect", flagcollect);
            params.put("likenum", likenum);
            params.put("flaglike", flaglike);
            params.put("commentnum", commentnum);

            params.put("name", name);
            params.put("time", time);
            params.put("sponsor", sponsor);
            params.put("introduce", introduce);
            params.put("typeid", typeid);


            Api.config(ApiConfig.Huodong_LIST, params).putRequest(new TtitCallback() {
                @Override
                public void onSuccess(final String res) {
                    Log.e("onSuccess",res);//res是一个json串，转化成实体类，通过实体类把token取出来
                }
                @Override
                public void onFailure(Exception e) {
                }
            });

        }


        private void addCollect(int eventid){
            HashMap<String, Object> params = new HashMap<String, Object>();//jianzhi
            params.put("eventid", eventid);
            Api.config(ApiConfig.Collect_LIST, params).postRequest(new TtitCallback() {
                @Override
                public void onSuccess(final String res) {
                    Log.e("onSuccess",res);//res是一个json串，转化成实体类，通过实体类把token取出来
                }
                @Override
                public void onFailure(Exception e) {
                }
            });
        }

        private void deleteCollect(final int eventid){
            HashMap<String, Object> params = new HashMap<String, Object>();
            //获取该活动在收藏表中对应的id
            Api.config(ApiConfig.Collect_LIST, params).getRequest(new TtitCallback() {
                @Override
                public void onSuccess(final String res) {
                    Log.e("onSuccess",res);
                    CollectListResponse response=new Gson().fromJson(res,CollectListResponse.class);
                    if (response != null && response.getCode() == 0){
                        List<CollectEntity> datas = response.getData();
                        for (CollectEntity data:datas){
                            int id=data.getId();
                            int ideventid=data.getEventid();
                            if (ideventid==eventid){
                                urlid =id;
                            }
                        }
                        System.out.println(urlid);
                        String collect=ApiConfig.Collect_LIST+"/"+ urlid;
                        deleteId(collect);

                    }
                }
                @Override
                public void onFailure(Exception e) {
                }
            });
        }

        private void deleteId(String collect){
            //删除收藏表中的id对应的数据
            HashMap<String, Object> paramshh = new HashMap<String, Object>();
            System.out.println(collect);
            Api.config(collect, paramshh).deleteRequest(new TtitCallback() {
                @Override
                public void onSuccess(final String res) {
                    Log.e("onSuccess",res);//res是一个json串
                }
                @Override
                public void onFailure(Exception e) {
                }
            });
        }
    }
}
