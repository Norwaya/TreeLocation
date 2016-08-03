package com.treelocation.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.treelocation.activity.di.ActivityComponent;
import com.treelocation.activity.di.ActivityModule;
import com.treelocation.activity.di.AppComponent;
import com.treelocation.activity.di.DaggerActivityComponent;
import com.treelocation.activity.entities.User;
import com.treelocation.activity.presenter.MyPresenter;

import java.util.ArrayList;


import javax.inject.Inject;

//import activity.treelocation.com.rxjava_dagger_realm.adapter.RecyclerAdapter;
//import activity.treelocation.com.rxjava_dagger_realm.di.ActivityComponent;
//import activity.treelocation.com.rxjava_dagger_realm.di.ActivityModule;
//import activity.treelocation.com.rxjava_dagger_realm.di.AppComponent;
//import activity.treelocation.com.rxjava_dagger_realm.di.DaggerActivityComponent;
//import activity.treelocation.com.rxjava_dagger_realm.di.ToastUtil;
//import activity.treelocation.com.rxjava_dagger_realm.represent.MyRespresent;
import io.realm.Realm;

public class MainActivity extends BaseActivity {
    String TAG = getClass().getSimpleName();
    TextView tv;

//    @Inject
//    MyRespresent respresent;
//
//    //
//    @Inject
//    ToastUtil toast;

    Realm realm;

    //    ActivityComponent component;
    ActionBar actionBar;
//    @BindView(R.id.my_recycler_view)
//    RecyclerView myRecyclerView;

    private String[] mPlanetTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        realm = Realm.getDefaultInstance();
        setContentView(R.layout.activity_main_drawer);
        initRecycler();
        initial();
        myRresenter.showUser();
    }


//    RecyclerAdapter adapter;

    private void initRecycler() {
//        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        adapter = new RecyclerAdapter(this);
//        myRecyclerView.setAdapter(adapter);
//        ArrayList<String> list = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            list.add("item_" + i);
//        }
//        adapter.setList(list);
    }

    ActionBarDrawerToggle mDrawerToggle;
    String mTitle, mDrawerTitle;

    private void initial() {
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        mPlanetTitles = getResources().getStringArray(R.array.planets_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        // Set the adapter for the list view
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, mPlanetTitles));
        // Set the list's click listener
        //mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        mTitle = mDrawerTitle = getTitle().toString();
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                mDrawerLayout,         /* DrawerLayout object */
                null,  /* nav drawer icon to replace 'Up' caret */
                R.string.drawer_open,  /* "open drawer" description */
                R.string.drawer_close  /* "close drawer" description */
        ) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                actionBar.setTitle(mTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                actionBar.setTitle(mDrawerTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };

        // Set the drawer toggle as the DrawerListener
        mDrawerLayout.addDrawerListener(mDrawerToggle);
    }
    /* Called whenever we call invalidateOptionsMenu() */

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        // If the nav drawer is open, hide action items related to the content view
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
        menu.findItem(R.id.action_websearch).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle your other action bar items...

        return super.onOptionsItemSelected(item);
    }

    ActivityComponent activityComponent;

    @Override
    void getAppcomponent(AppComponent appComponent) {
        activityComponent = DaggerActivityComponent
                .builder()
                .appComponent(appComponent)
                .activityModule(new ActivityModule(this))
                .build();
        activityComponent
                .inject(this);
    }

    @Inject
    User user;
    @Inject
    MyPresenter myRresenter;
    public void showUser(User user) {
        Log.d(TAG, "showUser: "+user.name);
    }
}
