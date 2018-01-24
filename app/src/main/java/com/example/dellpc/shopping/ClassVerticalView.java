package com.example.dellpc.shopping;

import java.util.ArrayList;

/**
 * Created by dell pc on 20-Jan-18.
 */

public class ClassVerticalView {
    int imageId;
    String productName;
    String productDes;
    String productPrice;
    ArrayList<CharSequence> list;

    public ClassVerticalView(int imageId, String productName,String productPrice, String productDes, ArrayList<CharSequence> list){
        this.imageId = imageId;
        this.productName  = productName;
        this.productDes = productDes;
        this.productPrice = productPrice;
        this.list = list;
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

    public String getProductPrice() {
        return productPrice;
    }

    public ArrayList<CharSequence> getList() {
        return list;
    }
}
