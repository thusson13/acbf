package com.acbf.provider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
	private static final String DBNAME = "acbf_db";
	public static final String BREWERY_TABLE = "brewery";
	public static final String BEER_TABLE = "beer";

	
	private static final String SQL_CREATE_BREWERY = "CREATE TABLE " +
		    BEER_TABLE +
		    " (" +
		    " _ID INTEGER PRIMARY KEY, " +
		    " NAME TEXT, " +
		    " STYLE TEXT, " +
		    " ABV DOUBLE" +
		    ")";
	
	private static final String SQL_CREATE_BEER = "CREATE TABLE " +
		    BREWERY_TABLE +
		    " (" +
		    " _ID INTEGER PRIMARY KEY, " +
		    " NAME TEXT, " +
		    " LOCATION TEXT, " +
		    " WEBSITE TEXT, " +
		    " TWITTER TEXT" +
		    ")";
	
	public DatabaseHelper(Context context) {
		 super(context, DBNAME, null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(SQL_CREATE_BREWERY);
		db.execSQL(SQL_CREATE_BEER);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}
}
