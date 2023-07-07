package com.example.bugawayme;

import android.widget.TextView;

public class RecycleViewMessageData implements Comparable<RecycleViewMessageData>{
    private int ImageViewResource;
    private String TextViewWho;
    private String TextViewNews;
    private String TextViewTime;
    private String TextViewNumber;

    public RecycleViewMessageData() {
        ImageViewResource = R.color.color_grey_et_background;
        TextViewWho = "陌生人";
        TextViewNews = "你好";
        TextViewTime = "2023-7-1";
        TextViewNumber = "0";
    }
    public RecycleViewMessageData(int imageViewResource, String textViewWho, String textViewNews, String textViewTime, String textViewNumber) {
        ImageViewResource = imageViewResource;
        TextViewWho = textViewWho;
        TextViewNews = textViewNews;
        TextViewTime = textViewTime;
        TextViewNumber = textViewNumber;
    }

    public int getImageViewResource() {
        return ImageViewResource;
    }

    public void setImageViewResource(int imageViewResource) {
        ImageViewResource = imageViewResource;
    }

    public String getTextViewWho() {
        return TextViewWho;
    }

    public void setTextViewWho(String textViewWho) {
        TextViewWho = textViewWho;
    }

    public String getTextViewNews() {
        return TextViewNews;
    }

    public void setTextViewNews(String textViewNews) {
        TextViewNews = textViewNews;
    }

    public String getTextViewTime() {
        return TextViewTime;
    }

    public void setTextViewTime(String textViewTime) {
        TextViewTime = textViewTime;
    }

    public String getTextViewNumber() {
        return TextViewNumber;
    }

    public void setTextViewNumber(String textViewNumber) {
        TextViewNumber = textViewNumber;
    }



    @Override
    public int compareTo(RecycleViewMessageData o) {
        return this.getTextViewTime().compareTo(o.getTextViewTime());//升序
    }
}
