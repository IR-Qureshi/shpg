package com.example.dellpc.shopping;

/**
 * Created by dell pc on 20-Jan-18.
 */

public class ClassVerticalView {
    int imageId;
    String productName;
    String productDes;

    public ClassVerticalView(int imageId, String productName, String productDes){
        this.imageId = imageId;
        this.productName  = productName;
        this.productDes = productDes;
    }

    public int getImageId() {
        return imageId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductDes() {
        return productDes;
    }
}
