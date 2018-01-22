package com.example.dellpc.shopping;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayShowTitleEnabled(false);
//        actionBar.setDisplayShowHomeEnabled(false);


        setContentView(R.layout.activity_main);
        try {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    startActivity(new Intent(MainActivity.this, ActivityCategory.class));

                    // MainActivity.this.finish();
                }
            }, 3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
