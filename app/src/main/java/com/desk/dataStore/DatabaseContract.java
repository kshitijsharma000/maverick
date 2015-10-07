package com.desk.dataStore;

import android.provider.BaseColumns;

/**
 * Created by kshitij.sharma on 10/1/2015.
 */
public final class DatabaseContract {

    public DatabaseContract() {
    }

    /* Inner class that defines the table contents */
    public static abstract class DataBaseEntry implements BaseColumns {
        public static final String TABLE_NAME = "UserDetails";
        public static final String COLUMN_NAME_USER_ID = "username";
        public static final String COLUMN_NAME_USER_PW = "password";

        //todo rohit.. add new columns here..
    }
}
