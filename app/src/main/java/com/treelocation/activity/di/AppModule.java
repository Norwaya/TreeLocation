package com.treelocation.activity.di;

import android.content.Context;

import com.treelocation.activity.entities.User;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by admin on 2016/8/3.
 */
@Module
public class AppModule {
    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }


    @Provides
    User provideUser() {
        return new User();
    }

}
