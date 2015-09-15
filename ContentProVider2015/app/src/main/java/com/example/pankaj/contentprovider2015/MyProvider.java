package com.example.pankaj.contentprovider2015;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.util.Log;

import java.util.HashMap;

/**
 * Created by Pankaj on 9/14/2015.
 */
public class MyProvider extends ContentProvider {
    public static final String PROVIDER_NAME = "com.example.pankaj.contentprovider2015.MyProvider";
    public static final String AUTHORITY_NAME = "content://" + PROVIDER_NAME + "/mydb";
    Uri CONTENT_URI = Uri.parse(AUTHORITY_NAME);
    static final int matcherid = 1;
    static final UriMatcher uriMatcher;
    ProviderDataBase dataBase;
    SQLiteDatabase sqLiteDatabase;
    HashMap<String, String> Value;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORITY_NAME, "mydb", matcherid);
        uriMatcher.addURI(AUTHORITY_NAME, "mydb/*", matcherid);
    }

    @Override
    public boolean onCreate() {
        try {
            dataBase = new ProviderDataBase(getContext());
            sqLiteDatabase = dataBase.getWritableDatabase();
        } catch (Exception ex) {
            Log.e("eeee", ex.toString());
        }
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder sqLiteQueryBuilder = new SQLiteQueryBuilder();
        switch (uriMatcher.match(uri)) {
            case matcherid:
                sqLiteQueryBuilder.setProjectionMap(Value);
                break;
            default:
                throw new IllegalArgumentException("unkanow parameter");
        }
        Cursor c = sqLiteQueryBuilder.query(sqLiteDatabase, projection, selection, selectionArgs, null, null, null);
        return c;
    }

    @Override
    public String getType(Uri uri) {
        switch (uriMatcher.match(uri)) {
            case matcherid:
                return "vnd.android.cursor.dir/mydb";
            default:
                throw new IllegalArgumentException();
        }
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        long rowid = sqLiteDatabase.insert(TABLENAME, null, values);
        if (rowid > 0) {
            Log.e("Data Inserted", "Data Inserted");
            Uri _uri = ContentUris.withAppendedId(CONTENT_URI, rowid);
            getContext().getContentResolver().notifyChange(_uri, null);
            return _uri;
        }
        throw new SQLException("Fail to insert value ");
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }

    public static final String DBNAME = "providerdb";
    public static final String TABLENAME = "providertable";
    public static final int VERSIONID = 1;

    class ProviderDataBase extends SQLiteOpenHelper {

        public String TCID = "pid";
        public String TCNAME = "pname";

        public ProviderDataBase(Context mContext) {
            super(mContext, DBNAME, null, VERSIONID);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table " + TABLENAME + " ( " + TCID + " INTEGER primary key, " + TCNAME + " TEXT )");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }

}
