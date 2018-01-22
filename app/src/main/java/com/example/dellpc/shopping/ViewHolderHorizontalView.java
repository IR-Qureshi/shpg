package com.example.dellpc.shopping;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by dell pc on 20-Jan-18.
 */

public class ViewHolderHorizontalView extends RecyclerView.ViewHolder{
    ImageView mImageView;
    TextView mProductName;
    CardView mCardView;

    public ViewHolderHorizontalView(View itemView) {
        super(itemView);

//        mCardView = (CardView) itemView.findViewById(R.id.cvHorizontal);
        mImageView = (ImageView) itemView.findViewById(R.id.product_photo);
        mProductName = (TextView) itemView.findViewById(R.id.prduct_name);

    }
}
