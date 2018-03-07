package com.herokuapp.cmpickle.primaryhelper.Database;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by cmpic on 3/3/2018.
 */

@Database(name = PrimaryHelperDatabase.NAME, version = PrimaryHelperDatabase.VERSION)
public class PrimaryHelperDatabase {

    public static final String NAME = "PrimaryHelperDatabase";
    public static final int VERSION = 1;
}
