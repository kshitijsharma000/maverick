package com.desk.dataStore;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kshitij.sharma on 10/1/2015.
 */
public class UserDBOpenHelper extends SQLiteOpenHelper {

    Context context;
    SQLiteDatabase.CursorFactory factory;

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "User.db";

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + DatabaseContract.DataBaseEntry.TABLE_NAME + " (" +
                    DatabaseContract.DataBaseEntry._ID + " INTEGER PRIMARY KEY," +
                    DatabaseContract.DataBaseEntry.COLUMN_NAME_USER_ID + TEXT_TYPE + COMMA_SEP +
                    DatabaseContract.DataBaseEntry.COLUMN_NAME_USER_PW + TEXT_TYPE + COMMA_SEP +
                    " )";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + DatabaseContract.DataBaseEntry.TABLE_NAME;

    public UserDBOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    //Todo Below read and write functions only to be called with Async task or serice..
    @Override
    public SQLiteDatabase getWritableDatabase() {
        return super.getWritableDatabase();
    }

    @Override
    public SQLiteDatabase getReadableDatabase() {
        return super.getReadableDatabase();
    }

    @Override
    public synchronized void close() {
        super.close();
    }
}
