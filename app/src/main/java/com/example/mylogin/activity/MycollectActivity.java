package com.example.mylogin.activity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import com.example.mylogin.R;
import com.example.mylogin.adapter.CollectAdapter;
import com.example.mylogin.api.Api;
import com.example.mylogin.api.ApiConfig;
import com.example.mylogin.api.TtitCallback;
import com.example.mylogin.entity.CollectEntity;
import com.example.mylogin.entity.CollectListResponse;
import com.example.mylogin.entity.CollectResponse;
import com.example.mylogin.entity.VideoEntity;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.concurrent.TimeUnit;

public class MycollectActivity extends BaseActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    List<VideoEntity> collectdata = new ArrayList<>();

    protected int initLayout() {
        return R.layout.activity_mycollect;
    }

    @Override
    protected void initView() {
        recyclerView=findViewById(R.id.recyclerView);//得到recycleview控件
    }

    @Override
    protected void initDate() {
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //给recycleView设置布局管理器，线性布局
        recyclerView.setLayoutManager(linearLayoutManager);
        getCollectList();

    }


    //获得收藏活动的id
    private void getCollectList(){
        HashMap<String, Object> params = new HashMap<String, Object>();
        Api.config(ApiConfig.Collect_LIST, params).getRequest(new TtitCallback() {
            @Override
            public void onSuccess(final String res){
                Log.e("onSuccess",res);
                CollectListResponse response=new Gson().fromJson(res,CollectListResponse.class);
                if (response != null && response.getCode() == 0){
                    List<CollectEntity> datas = response.getData();
//                    collectdata.clear();
                   for (CollectEntity data:datas){
                       int eventid=data.getEventid();
                       int id=data.getId();
                       System.out.println(id+":"+eventid);
                       getCollect(eventid);
                       try {
                           Thread.sleep(100);
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                   }
                }
            }
            @Override
            public void onFailure(Exception e) {
            }
        });

    }

    //通过接口活动res
    private void getCollect(int eventid){

        HashMap<String, Object> params = new HashMap<String, Object>();
        String collect=ApiConfig.Huodong_LIST+"/"+eventid;
        Api.config(collect, params).getRequest(new TtitCallback() {
            @Override
            public void onSuccess(final String res) {
                Log.e("onSuccess",res);
                Gson gson =new Gson();
                CollectResponse response=gson.fromJson(res,CollectResponse.class);
                if (response != null && response.getCode() == 0) {
//                    List<VideoEntity> datas = new ArrayList<>();
                    VideoEntity ve =new VideoEntity();
                    ve.setName(response.getData().getName());
                    ve.setSponsor(response.getData().getSponsor());
                    ve.setTime(response.getData().getTime());
                    ve.setIntroduce(response.getData().getIntroduce());
                    collectdata.add(ve);

                    final CollectAdapter collectAdapter = new CollectAdapter( mContext, collectdata);//datas传入到videofragment中来
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            recyclerView.setAdapter(collectAdapter);//将数据渲染的每一个item布局上去
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
