package com.example.matt.lister;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by matt on 2016/07/11.
 */
public class ListerDBHelper extends SQLiteOpenHelper {

    public ListerDBHelper(Context context) {
        super(context, ListerDictContract.DATABASE_NAME, null, ListerDictContract.DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ListerDictContract.UserLists.CREATE_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        //Well, this will have to be changed.
        //db.execSQL(ListerDictContract.ListEntry.DELETE_ENTRIES);
        //onCreate(db);
    }
    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Well, this will have to be changed.
        //onUpgrade(db, oldVersion, newVersion);
    }
}
