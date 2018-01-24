package com.example.dellpc.shopping;

import android.content.Context;
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
    CustomItemClickListener listener;
    Context mContext;

    public AdapterVerticalView(ArrayList<ClassVerticalView> Data) {
        list = Data;
    }

    @Override
    public ViewHolderVerticalView onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_vertical_items, parent, false);
        final ViewHolderVerticalView holder = new ViewHolderVerticalView(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(v, holder.getPosition());
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolderVerticalView holder, int position) {
        holder.mImageView.setImageResource(list.get(position).getImageId());
        holder.mProductName.setText(list.get(position).getProductName());
        holder.mProductPrice.setText(list.get(position).getProductPrice());
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    //adding adapter for on item click
    public AdapterVerticalView(Context mContext, ArrayList<ClassVerticalView> list, CustomItemClickListener listener) {
        this.list = list;
        this.mContext = mContext;
        this.listener = listener;
    }
}
