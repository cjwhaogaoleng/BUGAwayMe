package com.example.bugawayme;

public class RecycleViewData {

    private int ImageViewResource;
    private String TextViewText;

    public RecycleViewData(int imageViewResource, String textViewText) {
        ImageViewResource = imageViewResource;
        TextViewText = textViewText;
    }

    public int getImageViewResource() {
        return ImageViewResource;
    }

    public void setImageViewResource(int imageViewResource) {
        ImageViewResource = imageViewResource;
    }

    public String getTextViewText() {
        return TextViewText;
    }

    public void setTextViewText(String textViewText) {
        TextViewText = textViewText;
    }
}
