package com.example.bugawayme;

public class RecycleViewShopData {

    private int ImageViewResource;
    private String introduce;
    private String price;
    private String name;


    public RecycleViewShopData(int imageViewResource, String introduce, String price, String name) {
        this.ImageViewResource = imageViewResource;
        this.introduce = introduce;
        this.price = price;
        this.name = name;
    }

    public int getImageViewResource() {
        return ImageViewResource;
    }

    public void setImageViewResource(int imageViewResource) {
        ImageViewResource = imageViewResource;
    }


    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
