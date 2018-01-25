package com.example.dellpc.shopping;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ActivityItemDes extends AppCompatActivity {

    private Toolbar mToolbar;
    private TextView p_name;
    private TextView p_price;
    private ImageView p_image;
    private TextView p_des;
    private TextView p_sizes;
    private Button b_add;
    private ListView list_sizes;
    private ArrayAdapter<String> adapter;
    private MenuItem mSearchAction;
    private boolean isSearchOpened = false;
    private EditText edtSeach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_des);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        p_image = (ImageView) findViewById(R.id.des_product_photo);
        p_name = (TextView) findViewById(R.id.des_product_name);
        p_price = (TextView) findViewById(R.id.dec_product_price);
        p_des = (TextView) findViewById(R.id.dec_product_des);
        p_sizes = (TextView) findViewById(R.id.dec_product_size);
        b_add = (Button) findViewById(R.id.dec_product_des_b);


        Bundle b = getIntent().getBundleExtra("data");
        int image = b.getInt("imageId");
        String product_name = b.getString("itemName");
        String product_price = b.getString("itemPrice");
        String product_des  = b.getString("itemDes");
        final ArrayList listsize = b.getCharSequenceArrayList("sizes");

        p_image.setImageResource(image);
        p_name.setText(product_name);
        p_price.setText(product_price);
        p_des.setText(product_des);
        p_sizes.setText(listsize.toString());
        b_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(ActivityItemDes.this);
                dialog.setContentView(R.layout.custom_dialog_size);
                dialog.setTitle("Sizes");
                list_sizes= (ListView) dialog.findViewById(R.id.list_sizes);

                adapter = new ArrayAdapter(ActivityItemDes.this,android.R.layout.simple_list_item_1,listsize);
                list_sizes.setAdapter(adapter);
                dialog.show();
                list_sizes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Object o = list_sizes.getItemAtPosition(position);
                        String s = (String) o;
                        Log.d("check1",s);

                    }
                });
            }
        });

//        String product1 = getIntent().getStringExtra("itemName");
//        product = (TextView) findViewById(R.id.text4);
//        product.setText(product1);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;

    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        mSearchAction = menu.findItem(R.id.action_search);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_settings:
                return true;
            case R.id.action_search:
                handleMenuSearch();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
    protected void handleMenuSearch(){
        ActionBar action = getSupportActionBar(); //get the actionbar

        if(isSearchOpened){ //test if the search is open

            action.setDisplayShowCustomEnabled(false); //disable a custom view inside the actionbar
            action.setDisplayShowTitleEnabled(true); //show the title in the action bar

            //hides the keyboard
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(edtSeach.getWindowToken(), 0);

            //add the search icon in the action bar
            mSearchAction.setIcon(getResources().getDrawable(R.drawable.searchicon));

            isSearchOpened = false;
        } else { //open the search entry

            action.setDisplayShowCustomEnabled(true); //enable it to display a
            // custom view in the action bar.
            action.setCustomView(R.layout.search_bar);//add the custom view
            action.setDisplayShowTitleEnabled(false); //hide the title

            edtSeach = (EditText)action.getCustomView().findViewById(R.id.edtSearch); //the text editor

            //this is a listener to do a search when the user clicks on search button
            edtSeach.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                        doSearch();
                        return true;
                    }
                    return false;
                }
            });


            edtSeach.requestFocus();

            //open the keyboard focused in the edtSearch
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(edtSeach, InputMethodManager.SHOW_IMPLICIT);


            //add the close icon
            mSearchAction.setIcon(getResources().getDrawable(R.drawable.clearicon));

            isSearchOpened = true;
        }
    }
    @Override
    public void onBackPressed() {
        if(isSearchOpened) {
            handleMenuSearch();
            return;
        }
        super.onBackPressed();
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void doSearch() {
//
    }
}
