package com.example.dellpc.shopping;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by dell pc on 20-Jan-18.
 */

public class AdapterVerticalView extends RecyclerView.Adapter<ViewHolderVerticalView> {
    private ArrayList<ClassVerticalView> list;

    public AdapterVerticalView(ArrayList<ClassVerticalView> Data) {
        list = Data;
    }

    @Override
    public ViewHolderVerticalView onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_vertical_items, parent, false);
        ViewHolderVerticalView holder = new ViewHolderVerticalView(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolderVerticalView holder, int position) {
        holder.mImageView.setImageResource(list.get(position).getImageId());
        holder.mProductName.setText(list.get(position).getProductName());
        holder.mProductDes.setText(list.get(position).getProductDes());
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
