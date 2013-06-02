package com.acbf;

import java.util.ArrayList;
import java.util.List;

import com.acbf.data.Brewer;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;

public class BrewersList extends ListActivity implements OnItemClickListener {
	@Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        // We'll define a custom screen layout here (the one shown above), but
        // typically, you could just use the standard ListActivity layout.
        setContentView(R.layout.brewer_list);

        List<Brewer> brewerList = new ArrayList<Brewer>();
        brewerList.add(new Brewer("Sam Adams", "Boston", "samadams.com", "@samadams", 1));
        brewerList.add(new Brewer("Frog & Unicorn", "Sandwich", "frogandunicorn.com", "@fu", 2));
        
        ListAdapter adapter = new BrewerAdapter(this, brewerList);

        // Bind to our new adapter.
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Intent intent = new Intent();
		intent.setClass(this, BeerList.class);
		Brewer b = (Brewer) getListView().getItemAtPosition(position);
		intent.putExtra("brewer_id", b.getBrewerId());
		intent.putExtra("name", b.getName());
		if (!TextUtils.isEmpty(b.getWebsite())) {
			intent.putExtra("website", b.getWebsite());
		}
		if (!TextUtils.isEmpty(b.getTwitter())) {
			intent.putExtra("twitter", b.getTwitter());
		}
		startActivity(intent);
	}
}
