package com.ext.techapp.thirukkural.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Selvam on 11/22/2015.
 */
public  class FavoriteReaderDbHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "favorites.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + Favorites.FeedEntry.TABLE_NAME + " (" +
                    Favorites.FeedEntry.COLUMN_NAME_ENTRY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    Favorites.FeedEntry.COLUMN_COUPLET_ID + INTEGER_TYPE + COMMA_SEP +
                    Favorites.FeedEntry.COLUMN_CHAPTER_ID + INTEGER_TYPE  +

            " )";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + Favorites.FeedEntry.TABLE_NAME;

    public FavoriteReaderDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    };

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
