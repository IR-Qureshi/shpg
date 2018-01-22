package com.example.dellpc.shopping;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentItemDes extends Fragment {

    public TextView textView;

    public FragmentItemDes() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_fragment_item_des, container, false);
        textView = (TextView) view.findViewById(R.id.text3);
        String value = getArguments().getString("itemName");

        textView.setText(value);
        return view;
    }

}
