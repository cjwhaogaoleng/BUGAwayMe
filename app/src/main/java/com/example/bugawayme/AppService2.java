package com.example.bugawayme;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AppService2 {

    @GET("get_data.json")
    Call<testData> getData();

    @POST("login")
    @FormUrlEncoded
    Call<ResponseBody> up(@Field("username") String username, @Field("password") String password);

}
