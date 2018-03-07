package com.herokuapp.cmpickle.primaryhelper.Database.Tables;

import com.herokuapp.cmpickle.primaryhelper.Database.PrimaryHelperDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;

import java.util.Date;
import java.util.UUID;

/**
 * Created by cmpic on 3/3/2018.
 */

@Table(database = PrimaryHelperDatabase.class)
public class Kids {

    @PrimaryKey
    UUID id;

    @Column
    boolean inClass;

    @Column
    String firstName;

    @Column
    String lastName;

    @Column
    Date birthday;
}
