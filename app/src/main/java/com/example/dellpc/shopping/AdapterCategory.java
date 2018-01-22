package com.example.dellpc.shopping;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by dell pc on 17-Jan-18.
 */

public class AdapterCategory extends ArrayAdapter<ClassCategory> {

    public AdapterCategory(Context context, int resource, List<ClassCategory> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.custom_categ, parent, false);
        }
        TextView name = (TextView) convertView.findViewById(R.id.categName);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.categImg);

        ClassCategory classCategory = getItem(position);
        name.setText(classCategory.getCategName());
        imageView.setImageResource(classCategory.getImageId());

        return convertView;
    }
}
