package com.example.dellpc.shopping;

/**
 * Created by dell pc on 20-Jan-18.
 */

public class ClassHorizontalView {
    int imageId;
    String productName;

    public ClassHorizontalView(int imageId, String productName){
        this.imageId = imageId;
        this.productName = productName;
    }

    public int getImageId() {
        return imageId;
    }

    public String getProductName() {
        return productName;
    }
}
