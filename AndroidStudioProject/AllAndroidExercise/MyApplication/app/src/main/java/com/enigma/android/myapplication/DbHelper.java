package com.enigma.android.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "placeStreet";
    public static final String TABLE_QUEST = "place";
    public static final String KEY_ID = "id";
    public static final String KEY_STREET = "street";
    public static final String KEY_ANSWERRIGHT = "answerright";
    public static final String KEY_ANSWERLEFT = "answerleft";
    private SQLiteDatabase dbase;
    public DbHelper(Context context) {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase = db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_STREET
                + " TEXT, " + KEY_ANSWERRIGHT + " TEXT, " + KEY_ANSWERLEFT +
                " TEXT)";
        db.execSQL(sql);
        addPlace();
    }

    private void addPlace() {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
