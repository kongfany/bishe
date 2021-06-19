package com.example.mylogin.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mylogin.R;

public class MyMessageActivity extends BaseActivity {

    private EditText name;
    private EditText my_email;
    private EditText my_tel;
    private Button btn;
    private String id;
    private String username;
    private String password;
    private String email;
    private String tel;
    @Override
    protected int initLayout() {
        return R.layout.activity_my_message;
    }

    @Override
    protected void initView() {
        name=findViewById(R.id.my_name);
        my_email=findViewById(R.id.my_email);
        my_tel=findViewById(R.id.my_tel);
        btn=findViewById(R.id.my_update);
    }

    @Override
    protected void initDate() {
        message();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("修改成功");
            }
        });

    }

    private void message(){
        id=getStringFromSp("id");
        username=getStringFromSp("username");
        password=getStringFromSp("password");
        email=getStringFromSp("email");
        tel=getStringFromSp("tel");
        name.setText(username);
        my_email.setText(email);
        my_tel.setText(tel);

    }
}
