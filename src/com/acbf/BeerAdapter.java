package com.acbf;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.acbf.data.Beer;

public 	class BeerAdapter extends ArrayAdapter<Beer> {
	private LayoutInflater mInflater;
	public BeerAdapter(Context context, List<Beer> list) {
		super(context, R.layout.beer, list);
			mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		
		if (v == null) {
			v = mInflater.inflate(R.layout.beer, null);
		}
		
		Beer b = getItem(position);
		TextView name = (TextView) v.findViewById(R.id.name);
		TextView loc = (TextView) v.findViewById(R.id.type_abv);
		name.setText(b.getName());
		loc.setText(b.getStyle() + " - " + b.getAbv() + '%');
		return v;
	}
}
