package com.example.admin.testingapp;

import android.graphics.Bitmap;

/**
 * Created by admin on 10/17/2016.
 */

public class DataObject
{
    private String name;
    private String url;
    private Bitmap image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

}
