package com.example.dellpc.shopping;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ActivityCategory extends AppCompatActivity {
    ListView mListView;
    ArrayList<ClassCategory> mClassCategories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.custom_title);
        setContentView(R.layout.activity_category);

        mClassCategories = new ArrayList<>();
        mClassCategories.add(new ClassCategory("Gents",R.drawable.clothingone));
        mClassCategories.add(new ClassCategory("Ladies",R.drawable.clothingthree));
        mClassCategories.add(new ClassCategory("Summer",R.drawable.clothingtwo));
        mClassCategories.add(new ClassCategory("Winter",R.drawable.clothingfour));

        mListView = (ListView) findViewById(R.id.ctg_list);
        final AdapterCategory adapterCategory = new AdapterCategory(ActivityCategory.this,R.layout.custom_categ,mClassCategories);
        mListView.setAdapter(adapterCategory);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String categName = adapterCategory.getItem(position).getCategName();
                if(categName == "Gents"){
                    startActivity(new Intent(ActivityCategory.this, ActivityHome.class));
                }
                if(categName == "Ladies"){
                    startActivity(new Intent(ActivityCategory.this, ActivityHome.class));
                }
                if(categName == "Summer"){
                    startActivity(new Intent(ActivityCategory.this, ActivityHome.class));
                }
                if(categName == "Winter"){
                    startActivity(new Intent(ActivityCategory.this, ActivityHome.class));
                }
            }
        });
    }
}
