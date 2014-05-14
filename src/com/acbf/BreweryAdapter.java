package com.acbf;

import android.content.Context;
import android.database.Cursor;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.acbf.provider.ACBFProvider.BreweryColumns;

class BreweryAdapter extends CursorAdapter {
	private LayoutInflater mInflater;
	
	public BreweryAdapter(Context context, Cursor c) {
		super(context, c, false);
		mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public void bindView(View view, Context context, Cursor cursor) {
		fillFromCursor(view, cursor);		
	}

	@Override
	public View newView(Context context, Cursor cursor, ViewGroup parent) {
		View view = mInflater.inflate(R.layout.brewery, parent, false);

		fillFromCursor(view, cursor);

		return view;
	}
	
	private void fillFromCursor(View view, Cursor cursor) {
		TextView name = (TextView) view.findViewById(R.id.name);
		TextView loc = (TextView) view.findViewById(R.id.location_website);
		
		name.setText(cursor.getString(cursor.getColumnIndex(BreweryColumns.NAME)));
		
		Spannable spannable = new SpannableString(cursor.getString(cursor.getColumnIndex(BreweryColumns.LOCATION)) + " - " +
				cursor.getString(cursor.getColumnIndex(BreweryColumns.TWITTER)));
		Linkify.addLinks(spannable, Linkify.WEB_URLS);
		loc.setText(spannable); 
	}

}
