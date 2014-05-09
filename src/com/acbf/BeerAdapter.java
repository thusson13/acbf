package com.acbf;

import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.acbf.data.Beer;

public 	class BeerAdapter extends CursorAdapter {
	public BeerAdapter(Context context, Cursor c) {
		super(context, c, false);
		mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	private LayoutInflater mInflater;
	
//	public View getView(int position, View convertView, ViewGroup parent) {
//		View v = convertView;
//		
//		if (v == null) {
//			v = mInflater.inflate(R.layout.beer, null);
//		}
//		
//		Beer b = getItem(position);
//		TextView name = (TextView) v.findViewById(R.id.name);
//		TextView loc = (TextView) v.findViewById(R.id.type_abv);
//		name.setText(b.getName());
//		loc.setText(b.getStyle() + " - " + b.getAbv() + '%');
//		return v;
//	}

	@Override
	public void bindView(View view, Context context, Cursor cursor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public View newView(Context context, Cursor cursor, ViewGroup parent) {
		View view = mInflater.inflate(R.layout.beer, parent);
		
		return null;
	}
}
