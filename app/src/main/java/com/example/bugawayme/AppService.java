package com.example.bugawayme;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface AppService {

    @Headers("Content-Type:application/json")
    @POST("register")
    @FormUrlEncoded
    Call<ResponseBody> register(@Field("username") String username,
                                @Field("password") String password,
                                @Field("checkPassword") String checkPassword,
                                @Field("real_name") String real_name,
                                @Field("email") String email,
                                @Field("phone_number") int phone_number);



    @Headers("Content-Type:application/json")
    @POST("login")
    @FormUrlEncoded
    Call<ResponseBody> login(@Field("username") String username,
                                @Field("password") String password);



}
