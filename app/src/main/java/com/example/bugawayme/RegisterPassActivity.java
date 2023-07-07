package com.example.bugawayme;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.bugawayme.retrofitResponseData.JsonRootBean;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


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
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(" http://192.168.78.161:8000/user/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            JSONObject object = new JSONObject();
            try {

                object.put("username", "JohnDow");
                object.put("password", "mypassword");
                object.put("checkPassword", "mypassword");
                object.put("real_name", "John");
                object.put("email", "john.doe@example.com");
                object.put("phone_number", 123456789);

            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
            RequestBody body = FormBody.create(MediaType.parse("Content-Type:application/json "), object.toString());
            //RequestBody requestBody = RequestBody.create(MediaType.parse("Content-Type:application/json"), object.toString());

            Call<JsonRootBean> rootBeanCall = retrofit.create(AppService.class).register(body);
            try {
                Response<JsonRootBean> response = rootBeanCall.execute();
//                String decode = URLDecoder.decode(response.body().string(), "UTF-8");
//                GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create();

                Log.d(TAG, "up: " + response);
                if (response.body() != null) {
                    Log.d(TAG, "up: " + response.body().toString());
//                    Log.d(TAG, "up2: " + decode);

                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }).start();
    }
}


