package com.treelocation.activity.entities;

import io.realm.RealmModel;
import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmModule;
import io.realm.annotations.Required;

/**
 * Created by admin on 2016/8/3.
 */
public class User extends RealmObject {
    @PrimaryKey
    public long id;
    @Required
    public String name = "norwaya";
    @Ignore
    public String mark;
}
