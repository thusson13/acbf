package com.acbf;

import com.acbf.provider.ACBFProvider.BeerColumns;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public 	class BeerAdapter extends CursorAdapter {
	private LayoutInflater mInflater;

	public BeerAdapter(Context context, Cursor c) {
		super(context, c, false);
		mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public void bindView(View view, Context context, Cursor cursor) {
		fillFromCursor(view, cursor);
	}

	@Override
	public View newView(Context context, Cursor cursor, ViewGroup parent) {
		View view = mInflater.inflate(R.layout.beer, parent, false);

		fillFromCursor(view, cursor);

		return view;
	}
	
	private void fillFromCursor(View view, Cursor cursor) {
		TextView name = (TextView) view.findViewById(R.id.name);
		TextView loc = (TextView) view.findViewById(R.id.type_abv);
		name.setText(cursor.getString(cursor.getColumnIndex(BeerColumns.NAME)));
		loc.setText(cursor.getString(cursor.getColumnIndex(BeerColumns.STYLE)) + " - " + 
				cursor.getString(cursor.getColumnIndex(BeerColumns.ABV)) + '%');
	}
}
