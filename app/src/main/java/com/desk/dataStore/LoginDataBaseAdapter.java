package com.desk.dataStore;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by rohit02.kumar on 10/7/2015.
 */
public class LoginDataBaseAdapter
{
    static final String DATABASE_NAME = "login.db";
    static final int DATABASE_VERSION = 1;
    static final String TABLE_NAME ="UserTable ";
    public static final int NAME_COLUMN = 1;
    public static final String Col1="ID";
    public static final String Col2="USERNAME";
    public final static String Col3="PASSWORD";
    public final static String Col4="CONTACT NO";

    // TODO: Create public field for each column in your table.
    // SQL Statement to create a new database.
    static final String DATABASE_CREATE = "create table "+TABLE_NAME+
            "( " +Col1+" TEXT  primary key ,"+Col2+ " text,"+Col3+" text,"+Col4+" integer); ";
    // Variable to hold the database instance
    public SQLiteDatabase db;
    // Context of the application using the database.
    private final Context context;
    // Database open/upgrade helper
    private DataBaseHelper dbHelper;
    public  LoginDataBaseAdapter(Context _context)
    {
        context = _context;
        dbHelper = new DataBaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public  LoginDataBaseAdapter open() throws SQLException
    {
        db = dbHelper.getWritableDatabase();
        return this;
    }
    public void close()
    {
        db.close();
    }

    public  SQLiteDatabase getDatabaseInstance()
    {
        return db;
    }

    public void insertEntry(String Id ,String userName,String password,String contactno)
    {
        ContentValues newValues = new ContentValues();
        // Assign values for each row.
        newValues.put(Col1, Id);
        newValues.put(Col2, userName);
        newValues.put(Col3,password);
        newValues.put(Col4,contactno);

        // Insert the row into your table
        db.insert(TABLE_NAME, null, newValues);
        ///Toast.makeText(context, "Reminder Is Successfully Saved", Toast.LENGTH_LONG).show();
    }
    public int deleteEntry(String Id)
    {
        //String id=String.valueOf(ID);
        String where="ID=?";
        int numberOFEntriesDeleted= db.delete(TABLE_NAME, where, new String[]{Id}) ;
        // Toast.makeText(context, "Number fo Entry Deleted Successfully : "+numberOFEntriesDeleted, Toast.LENGTH_LONG).show();
        return numberOFEntriesDeleted;
    }
    public String getSinlgeEntry(String Id)
    {
        Cursor cursor=db.query(TABLE_NAME, null, " ID=?", new String[]{Id}, null, null, null);
        if(cursor.getCount()<1) // User does Not Exist
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String password= cursor.getString(cursor.getColumnIndex("PASSWORD"));
        cursor.close();
        return password;
    }
    public void  updateEntry(String Id,String userName,String password,String contactno)
    {
        // Define the updated row content.
        ContentValues updatedValues = new ContentValues();
        // Assign values for each row.
        updatedValues.put(Col1, Id);
        updatedValues.put(Col2, userName);
        updatedValues.put(Col3,password);
        updatedValues.put(Col4, contactno);

        String where="ID = ?";
        db.update(TABLE_NAME,updatedValues, where, new String[]{Id});
    }
}
