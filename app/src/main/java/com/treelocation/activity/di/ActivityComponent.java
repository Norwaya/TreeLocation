package com.treelocation.activity.di;

import com.treelocation.activity.MainActivity;

import dagger.Component;
import io.realm.Realm;

/**
 * Created by admin on 2016/8/3.
 */
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    MainActivity inject(MainActivity mainActivity);
}
