package com.example.bugawayme;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RegisterPassActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "tag";
    private EditText et_pass, et_pass_again;

    @BindView(R.id.register_pass_bt)
    Button bt_register_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_pass);
        ButterKnife.bind(this);
        initView();

    }

    private void initView() {
        et_pass = findViewById(R.id.et_register_pass_);
        et_pass_again = findViewById(R.id.et_register_pass_again);

        @SuppressLint("UseCompatLoadingForDrawables") Drawable drawable = getResources().getDrawable(R.drawable.closeeye);
        drawable.setBounds(-40, 0, 24, 64);
        et_pass_again.setCompoundDrawables(null, null, drawable, null);
        et_pass.setCompoundDrawables(null, null, drawable, null);

        bt_register_pass.setOnClickListener(this);
    }



    public void back(View view) {
        finish();
    }

    @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.register_pass_bt:
                    up();
                    break;

                default:
                    break;
            }
        }

    private void up() {
        new Thread(() -> {
            Retrofit retrofit = new Retrofit.Builder().baseUrl(" http://127.0.0.1:8000/user/").build();
            //"JohnDow",
            //
            //"password": "mypassword",
            //
            //"checkPassword": "mypassword",
            //
            //"real_name": "John",
            //
            //"email": "john.doe@example.com",
            //
            //"phone_number": 123456789
            Call<ResponseBody> call = retrofit.create(AppService.class).register("JohnDow",
                    "mypassword",
                    "mypassword",
                    "John",
                    "john.doe@example.com",
                    123456789);
            try {
                Response<ResponseBody> response = call.execute();
                Log.d(TAG, "up: " + response);
                if (response.body() != null) {
                    Log.d(TAG, "up: " + response.body().string());
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }).start();
    }

}