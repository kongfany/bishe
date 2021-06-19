package com.example.mylogin.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.mylogin.MainActivity;
import com.example.mylogin.R;
import com.example.mylogin.activity.LoginActivity;
import com.example.mylogin.activity.MyMessageActivity;
import com.example.mylogin.activity.MycollectActivity;

import butterknife.BindView;
import butterknife.OnClick;
import skin.support.SkinCompatManager;


public class MyFragment extends BaseFragment {

    private RelativeLayout layout;
    private RelativeLayout skin;
    private RelativeLayout collect;
    private RelativeLayout my;

    public MyFragment() {
    }

    public static MyFragment newInstance() {
        MyFragment fragment = new MyFragment();
        return fragment;
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initView() {
        layout = mRootView.findViewById(R.id.rl_logout);
        skin = mRootView.findViewById(R.id.rl_skin);
        collect = mRootView.findViewById(R.id.rl_collect);
        my = mRootView.findViewById(R.id.rl_my);
    }

    @Override
    protected void initDate() {

        //个人信息
        my.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateTo(MyMessageActivity.class);
                showToast("个人信息");
            }
        });
        //退出登录
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateTo(MainActivity.class);
                showToast("退出登录");
            }
        });
        //换肤
        skin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String skin = findByKey("skin");
                if (skin.equals("night")) {
                    // 恢复应用默认皮肤
                    SkinCompatManager.getInstance().restoreDefaultTheme();
                    insertVal("skin", "default");
                } else {
                    SkinCompatManager.getInstance().loadSkin("night", SkinCompatManager.SKIN_LOADER_STRATEGY_BUILD_IN); // 后缀加载
                    insertVal("skin", "night");
                }
                showToast("换肤");
            }
        });

        //收藏
        collect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateTo(MycollectActivity.class);
            }
        });
    }

}
