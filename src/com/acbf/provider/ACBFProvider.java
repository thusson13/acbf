package com.acbf.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class ACBFProvider extends ContentProvider {

	private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
	
	private static final int BREWERY = 1;
	private static final int BREWERY_ID = 2;

	private static final int BEER = 3;
	private static final int BEER_ID = 4;
	
	static {
		sUriMatcher.addURI("com.acbf.provider", "brewery",  BREWERY);
		sUriMatcher.addURI("com.acbf.provider", "brewery/#",  BREWERY_ID);

		sUriMatcher.addURI("com.acbf.provider", "beer", BEER);
		sUriMatcher.addURI("com.acbf.provider", "beer/#", BEER_ID);

	}
	
	private DatabaseHelper mOpenHelper;
	
	@Override
	public boolean onCreate() {
		mOpenHelper = new DatabaseHelper(getContext());
		return true;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		SQLiteDatabase db = mOpenHelper.getWritableDatabase();
		int match = sUriMatcher.match(uri);
		long id = 0;
		switch (match) {
		case BREWERY_ID:
			id = db.insert(DatabaseHelper.BREWERY_TABLE, null, values);
			getContext().getContentResolver().notifyChange(uri, null);
		    return Uri.parse("brewery/" + id);
		case BEER:
			id = db.insert(DatabaseHelper.BEER_TABLE, null, values);
			getContext().getContentResolver().notifyChange(uri, null);
		    return Uri.parse("beer/" + id);
		default:
		    throw new IllegalArgumentException("Unknown URI: " + uri);
		}
	}
	
	@Override
	public int delete(Uri arg0, String arg1, String[] arg2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		SQLiteDatabase db = mOpenHelper.getWritableDatabase();
		int match = sUriMatcher.match(uri);
		switch (match) {
		case BREWERY:
			return db.query(DatabaseHelper.BREWERY_TABLE, null, null, null, null, null, null);
		case BREWERY_ID:
			return db.query(DatabaseHelper.BREWERY_TABLE, null, "_ID = " + uri.getLastPathSegment(), null, null, null, null);
		case BEER:
			return db.query(DatabaseHelper.BEER_TABLE, null, null, null, null, null, null);
		case BEER_ID:
			return db.query(DatabaseHelper.BEER_TABLE, null, "_ID = " + uri.getLastPathSegment(), null, null, null, null);
		default:
			return null;
		}
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public String getType(Uri uri) {
		int match = sUriMatcher.match(uri);
		switch (match) {
		case BREWERY:
			return "vnd.android.cursor.dir/brewery";
		case BREWERY_ID:
			return "vnd.android.cursor.item/brewery";
		case BEER:
			return "vnd.android.cursor.dir/beer";
		case BEER_ID:
			return "vnd.android.cursor.item/beer";
		}
		return null;
	}
}
