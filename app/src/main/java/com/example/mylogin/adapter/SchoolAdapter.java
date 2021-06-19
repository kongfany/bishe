package com.example.mylogin.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mylogin.R;
import com.example.mylogin.entity.SchoolEntity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SchoolAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    private  Context mContext;
    private List<SchoolEntity> datas;
    public void setDatas(List<SchoolEntity> datas) {
        this.datas = datas;
    }

    public SchoolAdapter(Context context) {
        this.mContext = context;
    }
    public SchoolAdapter(Context context, List<SchoolEntity> datas) {
        this.mContext=context;
        this.datas=datas;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //加载布局
        View view=LayoutInflater.from(mContext).inflate(R.layout.item_school,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ViewHolder vh = (ViewHolder) holder;
        SchoolEntity schoolEntity=datas.get(position);
        vh.name.setText(schoolEntity.getName());
        vh.location.setText(schoolEntity.getLocation());
        //加载异步图片
        Picasso.with(mContext).load(schoolEntity.getUrl()).into(vh.img);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView name;
        private TextView location;
        private ImageView img;
        private ImageView imgLike;
        private boolean flagLike;

        public   ViewHolder(@NonNull View view) {
            super(view);
            name=view.findViewById(R.id.sch_name);
            location=view.findViewById(R.id.sch_location);
            img=view.findViewById(R.id.sch_pic);
            imgLike=view.findViewById(R.id.sch_like);
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
