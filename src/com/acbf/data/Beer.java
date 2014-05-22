package com.acbf.data;

import com.acbf.provider.ACBFProvider.BeerColumns;

import android.database.Cursor;

public class Beer {
	private int mId;
	private String mName;
	private int mBreweryId;
	private String mStyle;
	private double mAbv;
	
	public Beer(Cursor cursor) {
		mId = cursor.getInt(cursor.getColumnIndex(BeerColumns._ID));
		mBreweryId = cursor.getInt(cursor.getColumnIndex(BeerColumns.BREWERY_ID));
		mName = cursor.getString(cursor.getColumnIndex(BeerColumns.NAME));
		mStyle = cursor.getString(cursor.getColumnIndex(BeerColumns.STYLE));
		mAbv = cursor.getDouble(cursor.getColumnIndex(BeerColumns.ABV));
	}
	
	public String getName() {
		return mName;
	}
	
	public int getId() {
		return mId;
	}
	
	public int getBreweryId() {
		return mBreweryId;
	}
	
	public String getStyle() {
		return mStyle;
	}
	
	public double getAbv() {
		return mAbv;
	}
}
