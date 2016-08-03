package com.treelocation.activity.presenter;

import com.treelocation.activity.MainActivity;
import com.treelocation.activity.entities.User;

import java.util.ArrayList;

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

    public void showData() {
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            list.add("item" + i);
        }
        activity.showData(list);
    }
}
