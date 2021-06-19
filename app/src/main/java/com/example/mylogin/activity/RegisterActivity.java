package com.example.mylogin.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.mylogin.MainActivity;
import com.example.mylogin.R;
import com.example.mylogin.api.Api;
import com.example.mylogin.api.ApiConfig;
import com.example.mylogin.api.TtitCallback;
import com.example.mylogin.entity.LoginResponse;
import com.example.mylogin.util.StringUtils;
import com.google.gson.Gson;
import java.util.HashMap;

public class RegisterActivity extends BaseActivity {

    private EditText etAccount;
    private EditText etPwd;
    private Button btnRegister;

    @Override
    protected int initLayout() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {

        etAccount = findViewById(R.id.et_account);
        etPwd = findViewById(R.id.et_pwd);
        btnRegister = findViewById(R.id.btn_register);
    }

    @Override
    protected void initDate() {

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = etAccount.getText().toString().trim();//trim把获得的文本的前后空格去掉
                String pwd = etPwd.getText().toString().trim();
                register(account, pwd);
            }
        });
    }

    private void register(String account, String pwd) {
        if (StringUtils.isEmpty(account)) {
            showToast("请输入账号");
            return;
        }
        if (StringUtils.isEmpty(pwd)) {
            showToast("请输入密码");
            return;
        }
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("username", account);
        params.put("password", pwd);

        Api.config(ApiConfig.REGISTER, params).postRequest(new TtitCallback() {
            @Override
            public void onSuccess(final String res) {
                Log.e("onSuccess",res);//res是一个json串，转化成实体类，通过实体类把token取出来
                //showToastSyno(res);
                //gson库把Jason串转化为loginresponse实体类
                Gson gson =new Gson();
                LoginResponse loginResponse=gson.fromJson(res,LoginResponse.class);
                if(loginResponse.getCode()==0){
                    navigateTo(MainActivity.class);//注意与弹窗下一行代码的前后
                    showToastSyno("注册成功");
                }else {
                    showToastSyno("注册失败:"+loginResponse.getMsg());
                }
            }

            @Override
            public void onFailure(Exception e) {
                Log.e("onFailure",e.toString());
            }
        });
    }
}
