package com.example.dellpc.shopping;

/**
 * Created by dell pc on 17-Jan-18.
 */

public class ClassCategory {
    String categName;
    int imageId;

    public ClassCategory(String categName, int imageId){
        this. categName = categName;
        this.imageId = imageId;
    }

    public String getCategName() {
        return categName;
    }

    public int getImageId() {
        return imageId;
    }
}
