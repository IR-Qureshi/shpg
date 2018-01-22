package com.example.dellpc.shopping;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by dell pc on 20-Jan-18.
 */

public class AdapterHorizontalView extends RecyclerView.Adapter<ViewHolderHorizontalView> {
    private ArrayList<ClassHorizontalView> list;

    public AdapterHorizontalView(ArrayList<ClassHorizontalView> Data) {
        list = Data;
    }

    @Override
    public ViewHolderHorizontalView onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_horizontal_items, parent, false);
        ViewHolderHorizontalView holder = new ViewHolderHorizontalView(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolderHorizontalView holder, int position) {
        holder.mImageView.setImageResource(list.get(position).getImageId());
        holder.mProductName.setText(list.get(position).getProductName());

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
