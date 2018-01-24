package com.example.dellpc.shopping;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentHome extends Fragment {
    private ImageView headerImage;
    //horizontal
    private RecyclerView recyclerViewHorizontal;
    private ArrayList<ClassHorizontalView> classHorizontalViews;
    private AdapterHorizontalView adapterHorizontalView;

    //vertical
    private RecyclerView recyclerViewVertical;
    private ArrayList<ClassVerticalView> classVerticalViews;
    private AdapterVerticalView adapterVerticalView;


    public FragmentHome() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_home, container, false);

        //setting header image
        headerImage = (ImageView) view.findViewById(R.id.imageHeader);
        headerImage.setImageResource(R.drawable.headerimage);

        ///////////////////Horizontal Items////////////////////////
        classHorizontalViews = new ArrayList<>();
        classHorizontalViews.add(new ClassHorizontalView(R.drawable.clothingone,"ladies"));
        classHorizontalViews.add(new ClassHorizontalView(R.drawable.clothingtwo,"gents"));
        classHorizontalViews.add(new ClassHorizontalView(R.drawable.clothingthree,"summer"));
        classHorizontalViews.add(new ClassHorizontalView(R.drawable.clothingfour,"winter"));
        adapterHorizontalView = new AdapterHorizontalView(classHorizontalViews);

        recyclerViewHorizontal = (RecyclerView) view.findViewById(R.id.recyclerHorizontalItems);
        recyclerViewHorizontal.hasFixedSize();

        LinearLayoutManager MyLayoutManager = new LinearLayoutManager(getActivity());
        MyLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        if (classHorizontalViews.size() > 0 & recyclerViewHorizontal != null) {
            recyclerViewHorizontal.setAdapter(adapterHorizontalView);
        }
        recyclerViewHorizontal.setLayoutManager(MyLayoutManager);
        ///////////////////////////end horizontal view///////////////////////////////////////////

        ////////////////////Vertical Items/////////////////////////////
        classVerticalViews = new ArrayList<>();
        classVerticalViews.add(new ClassVerticalView(R.drawable.clothingone,"Ladies","PKR.500"));
        classVerticalViews.add(new ClassVerticalView(R.drawable.clothingtwo,"Gents","PKR.500"));
        classVerticalViews.add(new ClassVerticalView(R.drawable.clothingthree,"Summer","PKR.500"));
        classVerticalViews.add(new ClassVerticalView(R.drawable.clothingfour,"Winter","PKR.500"));
        adapterVerticalView = new AdapterVerticalView(getActivity(), classVerticalViews, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {

                Bundle bundle=new Bundle();
                String product = classVerticalViews.get(position).getProductName();
                String price = classVerticalViews.get(position).getProductDes();
                int image = classVerticalViews.get(position).getImageId();
                bundle.putString("itemName", product);
                bundle.putString("itemPrice", price);
                bundle.putInt("imageId",image);
//                FragmentItemDes fragmentItemDes = new FragmentItemDes();
//                fragmentItemDes.setArguments(bundle);
//                getFragmentManager().beginTransaction().replace(R.id.frameHome, fragmentItemDes).commit();
                Intent intent = new Intent(getActivity(),ActivityItemDes.class);
//                intent.putExtra("itemName", product);
                intent.putExtra("data", bundle);
//                intent.putExtra("itemPrice",price);
                startActivity(intent);

            }
        });

        recyclerViewVertical = (RecyclerView) view.findViewById(R.id.recyclerVerticalItems);

        if (classVerticalViews.size() > 0 & recyclerViewVertical != null) {
            recyclerViewVertical.setLayoutManager(new GridLayoutManager(getActivity(), 2));
            DecoratorRecyclerView itemDecoration = new DecoratorRecyclerView(getActivity(), R.dimen.item_offset);
            recyclerViewVertical.addItemDecoration(itemDecoration);
            recyclerViewVertical.setAdapter(adapterVerticalView);
        }
///////////////////////////end vertical view///////////////////////////////////////////
        return view;
    }

}
