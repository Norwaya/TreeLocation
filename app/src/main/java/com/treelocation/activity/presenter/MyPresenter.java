package com.treelocation.activity.presenter;

import com.treelocation.activity.MainActivity;
import com.treelocation.activity.entities.User;

/**
 * Created by admin on 2016/8/3.
 */
public class MyPresenter {
    MainActivity activity;
    User user;

    public MyPresenter(MainActivity activity, User user) {
        this.activity = activity;
        this.user = user;
    }

    public void showUser() {
        activity.showUser(user);
    }

}
