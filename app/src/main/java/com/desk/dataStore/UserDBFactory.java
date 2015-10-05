package com.desk.dataStore;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by kshitij.sharma on 10/1/2015.
 */
public class UserDBFactory {

    //Paas application context here
    Context context;
    UserDBOpenHelper openHelper;
    SQLiteDatabase database;

    public static UserDBFactory newInstance(Context context) {
        UserDBFactory factory = new UserDBFactory(context);
        return factory;
    }

    public UserDBFactory(Context context) {
        this.context = context;
        openHelper = new UserDBOpenHelper(context);
    }

    public void writeUserDB(String username, String password) {
        database = openHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);

        long rowid = database.insert(DatabaseContract.DataBaseEntry.TABLE_NAME, null, contentValues);
        System.out.println("row inserted with : " + rowid);
    }

    public ArrayList<String> readUserDB(){
        database = openHelper.getReadableDatabase();
        Cursor cursor = database.query(DatabaseContract.DataBaseEntry.TABLE_NAME,null,null,null,null,null,null);
        return null;
    }
}
