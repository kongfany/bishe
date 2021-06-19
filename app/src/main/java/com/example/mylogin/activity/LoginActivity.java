package com.example.mylogin.activity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mylogin.R;
import com.example.mylogin.api.Api;
import com.example.mylogin.api.ApiConfig;
import com.example.mylogin.api.TtitCallback;
import com.example.mylogin.entity.LoginResponse;
import com.example.mylogin.util.StringUtils;
import com.google.gson.Gson;

import java.util.HashMap;

public class LoginActivity extends BaseActivity {

    private EditText etAccount;
    private EditText etPwd;
    private Button btnLogin;


    @Override
    protected int initLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {

        etAccount = findViewById(R.id.et_account);
        etPwd = findViewById(R.id.et_pwd);
        btnLogin = findViewById(R.id.btn_login);
    }

    @Override
    protected void initDate() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = etAccount.getText().toString().trim();//trim把获得的文本的前后空格去掉
                String pwd = etPwd.getText().toString().trim();
                login(account, pwd);
            }
        });

    }

    private void login(String account, String pwd) {
        if (StringUtils.isEmpty(account)) {
            showToast("请输入账号");
            return;
        }
        if (StringUtils.isEmpty(pwd)) {
            showToast("请输入密码");
            return;
        }
        HashMap<String, Object> params = new HashMap<String, Object>();//jianzhi
        params.put("username", account);
        params.put("password", pwd);

        Api.config(ApiConfig.LOGIN, params).postRequest(new TtitCallback() {
            @Override
            public void onSuccess(final String res) {
                Log.e("onSuccess",res);//res是一个json串，转化成实体类，通过实体类把token取出来
                //showToastSyno(res);
                //gson库把Jason串转化为loginresponse实体类
                Gson gson =new Gson();
                LoginResponse loginResponse=gson.fromJson(res,LoginResponse.class);
                if(loginResponse.getCode()==0){
                    //将个人信息存在文件中
                    String id= String.valueOf(loginResponse.getData().getId());
                    saveStringToSp("id",id);
                    String username =loginResponse.getData().getUsername();
                    saveStringToSp("username",username);
                    String password =loginResponse.getData().getPassword();
                    saveStringToSp("password",password);
                    String email =loginResponse.getData().getEmail();
                    saveStringToSp("email",email);
                    String tel =loginResponse.getData().getTel();
                    saveStringToSp("tel",tel);
                    navigateTo(HomeActivity.class);//注意与弹窗下一行代码的前后
                    showToastSyno("登陆成功");
                }else {
                    showToastSyno("登录失败");
                }
            }
            @Override
            public void onFailure(Exception e) {
            }
        });
    }
//    public void write(){
//        String id= String.valueOf(loginResponse.getData().getId());
//        saveStringToSp("id",id);
//        String username =loginResponse.getData().getUsername();
//        saveStringToSp("username",username);
//        String password =loginResponse.getData().getPassword();
//        saveStringToSp("password",password);
//        String email =loginResponse.getData().getEmail();
//        saveStringToSp("email",email);
//        String tel =loginResponse.getData().getTel();
//        saveStringToSp("tel",tel);
//    }
}