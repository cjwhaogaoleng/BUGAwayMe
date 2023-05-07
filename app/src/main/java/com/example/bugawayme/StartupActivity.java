package com.example.bugawayme;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartupActivity extends AppCompatActivity implements View.OnClickListener {

    Button bt_login, bt_register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup);

        initView();
        bt_register.setOnClickListener(this);
        bt_login.setOnClickListener(this);


    }

    private void initView() {
        bt_login = findViewById(R.id.startup_bt_login);
        bt_register = findViewById(R.id.startup_bt_register);


    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.startup_bt_login:
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.startup_bt_register:
                startActivity(new Intent(this, RegisterActivity.class));
                    break;
            default:
                break;
        }
    }
}