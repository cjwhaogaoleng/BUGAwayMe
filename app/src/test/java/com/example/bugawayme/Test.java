package com.example.bugawayme;

import android.util.Log;
import android.view.textclassifier.TextLinks;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Test {
    private static final String TAG = "tag";

    @org.junit.Test
    public void testTest() {
        System.out.println("shenme");
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.0.100:8000/admin/")
                .build();
//        Gson gson = new GsonBuilder().create();
//        gson.toJson()
        Call<ResponseBody> data = retrofit.create(AppService2.class)
                .up("jon","12345")
                ;
        try {
            data.execute();
            System.out.println("3333");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void testTest2() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        FormBody formBody = new FormBody.Builder().add("username", "jon")
                .add("password", "12345")
                .build();
        Request request = new Request.Builder().url("http://192.168.0.100:8000/admin/login")
                .post(formBody)
                .build();
        try {
            Response response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                System.out.println(response);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
