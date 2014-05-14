package com.acbf.provider;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
	private static final String DBNAME = "acbf.db";
	public static final String BREWERY_TABLE = "brewery";
	public static final String BEER_TABLE = "beer";
	
	private static final String SQL_CREATE_BEER = "CREATE TABLE " +
		    BEER_TABLE +
		    " (" +
		    " _id INTEGER PRIMARY KEY, " +
		    " brewery_id INTEGER, " + 
		    " name TEXT, " +
		    " style TEXT, " +
		    " abv DOUBLE" +
		    ")";
	
	private static final String SQL_CREATE_BREWERY = "CREATE TABLE " +
		    BREWERY_TABLE +
		    " (" +
		    " _id INTEGER PRIMARY KEY, " +
		    " name TEXT, " +
		    " location TEXT, " +
		    " twitter TEXT" +
		    ")";
	
	public DatabaseHelper(Context context) {
		 super(context, DBNAME, null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(SQL_CREATE_BREWERY);
		db.execSQL(SQL_CREATE_BEER);
		
		db.insert(BREWERY_TABLE, null, buildBrewery("Abita Brewing Co.", "Abita Springs, Louisiana", "theabitabeer"));
		db.insert(BEER_TABLE, null, buildBeer("Andygator", 1, "Maibock / Helles Bock", 8.00));
		db.insert(BEER_TABLE, null, buildBeer("Jockamo IPA", 1,  "American IPA", 6.50));
		db.insert(BEER_TABLE, null, buildBeer("Purple Haze", 1, "Fruit / Vegetable Beer", 4.20));
		db.insert(BEER_TABLE, null, buildBeer("Seersucker", 1, "Pilsner", 4.80));
		db.insert(BEER_TABLE, null, buildBeer("Turbodog", 1, "English Brown Ale", 5.60));

		db.insert(BREWERY_TABLE, null, buildBrewery("Aeronaut Brewing Company", "Somerville, Massachusetts", "aeronautbrewing"));
		db.insert(BEER_TABLE, null, buildBeer("Session With Dr. Nandu", 2, "American Pale Ale", 4.50));

		 db.insert(BREWERY_TABLE, null, buildBrewery("Allagash Brewing Company.", "Portland, Maine", "allagashbrewing"));
		 db.insert(BEER_TABLE, null, buildBeer("Allagash James Bean", 3, "Tripel", 10.30));
		 db.insert(BEER_TABLE, null, buildBeer("Allagash Midnight Brett", 3, "American Wild Ale", 7.30));
		 db.insert(BEER_TABLE, null, buildBeer("Allagash Saison Ale", 3, "Saison / Farmhouse Ale", 6.10));
		 db.insert(BEER_TABLE, null, buildBeer("Allagash White", 3, "Witbier", 5.00));
		 
		 System.out.println("tom done adding");
	}
	
	private ContentValues buildBrewery(String name, String location, String twitter) {
		ContentValues values = new ContentValues();
		values.put("name", name);
		values.put("location", location);
		values.put("twitter", twitter);
		return values;
	}
	
	private ContentValues buildBeer(String name, int breweryId, String style, double abv) {
		ContentValues values = new ContentValues();
		values.put("name", name);
		values.put("brewery_id", breweryId);
		values.put("style", style);
		values.put("abv", abv);
		return values;
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}
}
