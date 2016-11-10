package com.example.matt.lister;

import android.provider.BaseColumns;

/**
 * Created by matt on 2016/07/11.
 */
public final class ListerDictContract {
    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    // If you change the database schema, you must increment the database version.
    public static final  int    DATABASE_VERSION   = 1;
    public static final  String DATABASE_NAME      = "database.db";
    private static final String TEXT_TYPE          = " TEXT";
    private static final String COMMA_SEP          = ",";

    public ListerDictContract() {
    }

    /* Inner class that defines the table contents */
    public static abstract class ListEntry implements BaseColumns {
        public static final String TABLE_NAME = "userlists";
        public static final String COLUMN_NAME_LISTNAME = "List Name";
        public static final String CREATE_ENTRIES =
                        "CREATE TABLE " + TABLE_NAME + " (" + _ID +
                        " INTEGER PRIMARY KEY," + TEXT_TYPE + COMMA_SEP +
                        COLUMN_NAME_LISTNAME + " )";
        public static final String DELETE_ENTRIES = "DROP TABLE IF EXISTS " + ListEntry.TABLE_NAME;
    }
    public static abstract class ItemsEntry implements BaseColumns {
        public static final String TABLE_NAME = "listItems"; //But this will change? This contract class idea has some flaws. And is making things unneccesarily complicated
        public static final String COLUMN_NAME_ITEMS = "Items";
        public static final String CREATE_ENTRIES =
                "CREATE TABLE " + TABLE_NAME + " (" + _ID +
                        " INTEGER PRIMARY KEY," + TEXT_TYPE + COMMA_SEP +
                        COLUMN_NAME_ITEMS + " )";
        public static final String DELETE_ENTRIES = "DROP TABLE IF EXISTS " + ItemsEntry.TABLE_NAME;
    }
}

