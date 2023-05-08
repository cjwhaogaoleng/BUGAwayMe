package com.example.bugawayme.tempTool;

import com.google.gson.Gson;

import java.net.URLEncoder;

import org.json.JSONObject;

public class SendMessage {

    public static final String APPKEY = "your_appkey_here";// 你的appkey
    public static final String URL = "http://api.binstd.com/sms/send";
    public static final String mobile = "18395920855";// 手机号
    public static final String content = "用户您好。【极速数据】";// utf-8

    public static void Get() throws Exception {
        String result = null;
        String url = URL + "?mobile=" + mobile + "&content=" + URLEncoder.encode(content, "utf-8") + "&appkey="
                + APPKEY;

        try {
            result = HttpUtil.sendGet(url, "utf-8");
            Gson gson = new Gson();
            String toJson = gson.toJson(result);
            JSONObject json = new JSONObject(toJson);
            if (json.getInt("status") != 0) {
                System.out.println(json.getString("msg"));
            } else {
                JSONObject resultarr = json.optJSONObject("result");
                String count = resultarr.getString("count");
                String accountid = resultarr.getString("accountid");
                System.out.println(count + " " + accountid);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}