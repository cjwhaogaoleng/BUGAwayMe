package com.example.bugawayme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bugawayme.loginFragment.PasswordFragment;
import com.example.bugawayme.loginFragment.VerificationFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    @SuppressLint("NonConstantResourceId")
//    @BindView(R.id.tv_protocol_login)
//    TextView tv_protocol_login;
//    @BindView(R.id.tv_login_password)
//    TextView tv_password;
//    @BindView(R.id.tv_login_verification)
//    TextView tv_verification;
//    @BindViews({R.id.tv_protocol_login, R.id.tv_login_password, R.id.tv_login_verification})
//    List<TextView> tv;
    TextView tv_protocol_login, tv_password, tv_verification;



    Toolbar toolbar;
    Button bt_login;
    ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        intiView();
        initPager();
        getBlueText();
    }

    private void initPager() {


        List<Fragment> list = new ArrayList<>();
        list.add(VerificationFragment.newInstance("", ""));
        list.add(PasswordFragment.newInstance("", ""));
        MyFragmentPagerAdapter myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), getLifecycle(), list);

        viewPager2.setAdapter(myFragmentPagerAdapter);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                changeTypeOfLogin(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }

    private void changeTypeOfLogin(int position) {
        switch (position) {
            case 0:
                tv_verification.setSelected(true);
                tv_password.setSelected(false);
                break;
            case 1:
                tv_password.setSelected(true);
                tv_verification.setSelected(false);
                break;
        }
    }

    private void getBlueText() {
        String text;

        text = "已阅读并同意，畅易游《用户协议》和《隐私协议》";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();

        spannableStringBuilder.append(text);
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Toast.makeText(LoginActivity.this, "触发事件", Toast.LENGTH_SHORT).show();
            }
        };
        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Toast.makeText(LoginActivity.this, "触发事件1", Toast.LENGTH_SHORT).show();
            }
        };
        spannableStringBuilder.setSpan(clickableSpan, text.indexOf('《'), text.indexOf('》') + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableStringBuilder.setSpan(clickableSpan1, text.indexOf('《') + 7, text.indexOf('》') + 8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.parseColor("#1F8CAE"));
        spannableStringBuilder.setSpan(foregroundColorSpan, text.indexOf('《'), text.indexOf('》') + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableStringBuilder.setSpan(foregroundColorSpan, text.indexOf('《') + 7, text.indexOf('》') + 8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


        tv_protocol_login.setMovementMethod(LinkMovementMethod.getInstance());
        tv_protocol_login.setText(spannableStringBuilder);

    }

    private void intiView() {
        tv_protocol_login = findViewById(R.id.tv_protocol_login);
        toolbar = findViewById(R.id.toolbar_login);
        viewPager2 = findViewById(R.id.vp_login);
        tv_verification = findViewById(R.id.tv_login_verification);
        tv_password = findViewById(R.id.tv_login_password);
        bt_login = findViewById(R.id.login_bt_login);


        tv_password.setOnClickListener(this);
        tv_verification.setOnClickListener(this);
        bt_login.setOnClickListener(this);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_login_verification:
                viewPager2.setCurrentItem(0);
                break;
            case R.id.tv_login_password:
                viewPager2.setCurrentItem(1);
                break;
            case R.id.login_bt_login:
                startActivity(new Intent(this, MainActivity.class));
        }
    }
}