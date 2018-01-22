package com.example.dellpc.shopping;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ActivityHome extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Toolbar mToolbar;
    private MenuItem mSearchAction;
    private boolean isSearchOpened = false;
    private EditText edtSeach;
    private ImageView headerImage;
    //horizontal
    private RecyclerView recyclerViewHorizontal;
    private ArrayList<ClassHorizontalView> classHorizontalViews;
    private AdapterHorizontalView adapterHorizontalView;

    //vertical
    private RecyclerView recyclerViewVertical;
    private ArrayList<ClassVerticalView> classVerticalViews;
    private AdapterVerticalView adapterVerticalView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(ActivityHome.this);

        headerImage = (ImageView) findViewById(R.id.imageHeader);
        headerImage.setImageResource(R.drawable.headerimage);

        ///////////////////Horizontal Items////////////////////////
        classHorizontalViews = new ArrayList<>();
        classHorizontalViews.add(new ClassHorizontalView(R.drawable.clothingone,"ladies"));
        classHorizontalViews.add(new ClassHorizontalView(R.drawable.clothingtwo,"gents"));
        classHorizontalViews.add(new ClassHorizontalView(R.drawable.clothingthree,"summer"));
        classHorizontalViews.add(new ClassHorizontalView(R.drawable.clothingfour,"winter"));
        adapterHorizontalView = new AdapterHorizontalView(classHorizontalViews);

        recyclerViewHorizontal = (RecyclerView) findViewById(R.id.recyclerHorizontalItems);
        recyclerViewHorizontal.hasFixedSize();

        LinearLayoutManager MyLayoutManager = new LinearLayoutManager(ActivityHome.this);
        MyLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        if (classHorizontalViews.size() > 0 & recyclerViewHorizontal != null) {
            recyclerViewHorizontal.setAdapter(adapterHorizontalView);
        }
        recyclerViewHorizontal.setLayoutManager(MyLayoutManager);

        ////////////////////Vertical Items/////////////////////////////
        classVerticalViews = new ArrayList<>();
        classVerticalViews.add(new ClassVerticalView(R.drawable.clothingone,"Ladies","PKR.500"));
        classVerticalViews.add(new ClassVerticalView(R.drawable.clothingtwo,"Gents","PKR.500"));
        classVerticalViews.add(new ClassVerticalView(R.drawable.clothingthree,"Summer","PKR.500"));
        classVerticalViews.add(new ClassVerticalView(R.drawable.clothingfour,"Winter","PKR.500"));
        adapterVerticalView = new AdapterVerticalView(classVerticalViews);

        recyclerViewVertical = (RecyclerView) findViewById(R.id.recyclerVerticalItems);
//        recyclerViewVertical.hasFixedSize();

        if (classVerticalViews.size() > 0 & recyclerViewVertical != null) {
            recyclerViewVertical.setLayoutManager(new GridLayoutManager(ActivityHome.this, 2));
            DecoratorRecyclerView itemDecoration = new DecoratorRecyclerView(ActivityHome.this, R.dimen.item_offset);
            recyclerViewVertical.addItemDecoration(itemDecoration);
            recyclerViewVertical.setAdapter(adapterVerticalView);
        }
//
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
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
        super.onBackPressed();
    }

    private void doSearch() {
//
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
