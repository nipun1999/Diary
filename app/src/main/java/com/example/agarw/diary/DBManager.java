package com.example.agarw.diary;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.SQLException;
import android.content.ContentValues;

/**
 * Created by agarw on 12/26/2017.
 */

public class DBManager {

    private DatabaseHelper dbHelper;
    private Context context;
    private SQLiteDatabase database;

    public DBManager(Context c) {
        context = c;
    }

    public DBManager open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }
    public void close() {
        dbHelper.close();
    }

    public void insert(String heading, String notes) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseHelper.HEADING, heading);
        contentValue.put(DatabaseHelper.NOTES, notes);
        database.insert(DatabaseHelper.TABLE_NAME, null, contentValue);
    }

    public Cursor fetch() {
        String[] columns = new String[] { DatabaseHelper._ID, DatabaseHelper.HEADING, DatabaseHelper.NOTES };
        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int update(long _id, String heading, String notes) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.HEADING, heading);
        contentValues.put(DatabaseHelper.NOTES, notes);
        int i = database.update(DatabaseHelper.TABLE_NAME, contentValues, DatabaseHelper._ID + " = " + _id, null);
        return i;
    }

    public void delete(long _id) {
        database.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper._ID + "=" + _id, null);
    }







}
