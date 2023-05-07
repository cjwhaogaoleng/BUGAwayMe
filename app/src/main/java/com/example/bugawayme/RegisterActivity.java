package com.example.bugawayme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.chip.Chip;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_protocol_register;
    private Button bt_register;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initView();
        getBlueText();
    }

    private void initView() {
        tv_protocol_register = findViewById(R.id.tv_protocol_register);
        bt_register = findViewById(R.id.register_bt_login);

        bt_register.setOnClickListener(this);
    }


    private void getBlueText() {
        String text;
        text = "已阅读并同意，畅易游《用户协议》和《隐私协议》";

        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();

        spannableStringBuilder.append(text);
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Toast.makeText(RegisterActivity.this, "触发事件", Toast.LENGTH_SHORT).show();
            }
        };
        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Toast.makeText(RegisterActivity.this, "触发事件1", Toast.LENGTH_SHORT).show();
            }
        };
        spannableStringBuilder.setSpan(clickableSpan, text.indexOf('《'), text.indexOf('》') + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableStringBuilder.setSpan(clickableSpan1, text.indexOf('《') + 7, text.indexOf('》') + 8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.parseColor("#1F8CAE"));
        spannableStringBuilder.setSpan(foregroundColorSpan, text.indexOf('《'), text.indexOf('》') + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableStringBuilder.setSpan(foregroundColorSpan, text.indexOf('《') + 7, text.indexOf('》') + 8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


        tv_protocol_register.setMovementMethod(LinkMovementMethod.getInstance());
        tv_protocol_register.setText(spannableStringBuilder);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register_bt_login:
                Intent intent = new Intent(this, RegisterPassActivity.class);
                startActivity(intent);
                break;

            default:
                break;
        }
    }

    public void back(View view) {
        finish();
    }
}