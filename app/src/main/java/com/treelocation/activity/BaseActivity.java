package com.treelocation.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.treelocation.activity.di.AppComponent;

/**
 * Created by admin on 2016/8/3.
 */
public abstract class BaseActivity extends AppCompatActivity {

    String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppComponent appComponent;
        appComponent = ((MyApplication) getApplication()).getAppComponent();
        getAppcomponent(appComponent);


    }

    abstract void getAppcomponent(AppComponent appComponent);


}