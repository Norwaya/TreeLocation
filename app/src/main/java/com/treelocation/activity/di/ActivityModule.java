package com.treelocation.activity.di;

import com.treelocation.activity.MainActivity;
import com.treelocation.activity.entities.User;
import com.treelocation.activity.presenter.MyPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by admin on 2016/8/3.
 */
@Module
public class ActivityModule {
    private MainActivity mainActivity;
    public ActivityModule(MainActivity activity) {
        mainActivity = activity;
    }
    @Provides
    MainActivity provideMainActivity(){
        return mainActivity;
    }
    @Provides
    MyPresenter provideMyPresenter(User user){
        return new MyPresenter(mainActivity, user);
    }
}
