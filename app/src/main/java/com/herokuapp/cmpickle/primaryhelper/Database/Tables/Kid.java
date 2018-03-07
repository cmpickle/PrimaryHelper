package com.herokuapp.cmpickle.primaryhelper.Database.Tables;

import com.herokuapp.cmpickle.primaryhelper.Database.PrimaryHelperDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.Date;
import java.util.UUID;

/**
 * Created by cmpic on 3/3/2018.
 */

@Table(database = PrimaryHelperDatabase.class)
public class Kid extends BaseModel {

    @PrimaryKey
    public UUID id;

    @Column
    public boolean inClass;

    @Column
    public String firstName;

    @Column
    public String lastName;

    @Column
    public Date birthday;
}
