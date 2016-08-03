package com.treelocation.activity;

import android.app.Application;

import com.treelocation.activity.di.AppComponent;
import com.treelocation.activity.di.AppModule;
import com.treelocation.activity.di.DaggerAppComponent;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by admin on 2016/8/3.
 */
public class MyApplication extends Application {
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        appComponent.inject(this);
        RealmConfiguration realmConfig = new RealmConfiguration.Builder(this).build();
        Realm.setDefaultConfiguration(realmConfig);
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
