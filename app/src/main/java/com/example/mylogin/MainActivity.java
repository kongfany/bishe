package com.example.mylogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mylogin.activity.BaseActivity;
import com.example.mylogin.activity.LoginActivity;
import com.example.mylogin.activity.RegisterActivity;

public class MainActivity extends BaseActivity {
    private Button btnLogin;
    private Button btnRegister;

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        btnLogin=findViewById(R.id.btn_login);
        btnRegister=findViewById(R.id.btn_register);
    }

    @Override
    protected void initDate() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateTo(LoginActivity.class);
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateTo(RegisterActivity.class);
            }
        });

    }
}



