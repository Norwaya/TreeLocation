package com.treelocation.activity.di;

import com.treelocation.activity.MyApplication;
import com.treelocation.activity.entities.User;

import dagger.Component;
import io.realm.Realm;

/**
 * Created by admin on 2016/8/3.
 */
@Component(modules = AppModule.class)
public interface AppComponent {
    MyApplication inject(MyApplication application);
    User user();
}
