package com.example.dellpc.shopping;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by dell pc on 20-Jan-18.
 */

public class ViewHolderVerticalView extends RecyclerView.ViewHolder{
    ImageView mImageView;
    TextView mProductName;
    TextView mProductDes;
    Button mButtonAdd;
    CardView mCardView;

    public ViewHolderVerticalView(View itemView) {
        super(itemView);

        mCardView = (CardView) itemView.findViewById(R.id.card_view);
        mImageView = (ImageView) itemView.findViewById(R.id.cvhImage);
        mProductName = (TextView) itemView.findViewById(R.id.cvhProductName);
        mProductDes = (TextView) itemView.findViewById(R.id.cvhProductDes);

    }
}