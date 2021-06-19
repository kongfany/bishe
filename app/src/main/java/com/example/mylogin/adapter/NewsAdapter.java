package com.example.mylogin.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mylogin.R;
import com.example.mylogin.entity.NewsEntity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<NewsEntity> datas;

    public void setDatas(List<NewsEntity> datas) {
        this.datas = datas;
    }

    public NewsAdapter(Context context) {
        this.mContext = context;
    }

    public NewsAdapter(Context context, List<NewsEntity> datas) {
        this.mContext = context;
        this.datas = datas;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //加载布局
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_scenery, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //获取布局
        NewsEntity newsEntity=datas.get(position);
        //给布局渲染数据
        ViewHolder vh = (ViewHolder) holder;
        vh.name.setText(newsEntity.getName());
        vh.location.setText(newsEntity.getLocation());
        vh.type.setText(newsEntity.getType());
        vh.introduce.setText(newsEntity.getIntroduce());

        //加载异步图片
        Picasso.with(mContext).load(newsEntity.getUrl()).into(vh.img);

    }

    @Override
    public int getItemCount() {
        if (datas != null && datas.size() > 0) {
            return datas.size();
        } else {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //控件对象
        private TextView name;
        private TextView location;
        private TextView type;
        private TextView introduce;
        private ImageView img;
        private ImageView imgLike;
        private boolean flagLike;

        public ViewHolder(@NonNull View view) {
            super(view);
            //给控件赋值
            name=view.findViewById(R.id.sc_name);
            location=view.findViewById(R.id.sc_location);
            type=view.findViewById(R.id.sc_type);
            introduce=view.findViewById(R.id.sc_introduce);
            img=view.findViewById(R.id.sc_pic);
            imgLike=view.findViewById(R.id.sc_like);


            imgLike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (flagLike){//已经dianz
                        imgLike.setImageResource(R.mipmap.dianzan);
                        Toast.makeText(mContext,"取消点赞",Toast.LENGTH_SHORT).show();

                    }else {//未dianz
                        imgLike.setImageResource(R.mipmap.dianzan_select);
                        Toast.makeText(mContext,"点赞",Toast.LENGTH_SHORT).show();
                    }
                    flagLike=!flagLike;
                }
            });
        }
    }



}

