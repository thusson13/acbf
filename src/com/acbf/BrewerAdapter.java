package com.acbf;

import java.util.List;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.acbf.data.Brewer;

class BrewerAdapter extends ArrayAdapter<Brewer> {
	private LayoutInflater mInflater;
	
	public BrewerAdapter(Context context, List<Brewer> list) {
		super(context, R.layout.brewer, list);
		mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		
		if (v == null) {
			v = mInflater.inflate(R.layout.brewer, null);
		}
		
		Brewer b = getItem(position);
		TextView name = (TextView) v.findViewById(R.id.name);
		TextView loc = (TextView) v.findViewById(R.id.location_website);
		name.setText(b.getName());
		
		Spannable spannable = new SpannableString(b.getLocation() + " - " + b.getWebsite());
		Linkify.addLinks(spannable, Linkify.WEB_URLS);
		loc.setText(spannable); 
		
		return v;
	}
}
