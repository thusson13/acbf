package com.acbf;

import java.util.ArrayList;
import java.util.List;

import com.acbf.data.Beer;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.CursorAdapter;

public class BeerList extends ListActivity implements OnItemClickListener, OnClickListener {
	@Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beers_list);
    }
	
	@Override
	protected void onStart() {
		super.onStart();
		Intent intent = getIntent();
		int brewerId = intent.getExtras().getInt("brewer_id");
		
        List<Beer> beerList = new ArrayList<Beer>();
        if (brewerId == 1) {
        	beerList.add(new Beer("Boston Lager", 1, "American Ale", 5.0));
        } else {
        	beerList.add(new Beer("Boston Red", 2, "Red Ale", 7.0));
        }
        
        Cursor cursor = getContentResolver().query(Uri.parse("com.acbf.provider/beer"), null, null, null, null);
        CursorAdapter adapter = new BeerAdapter(this, cursor);

        // Bind to our new adapter.
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
        
        ActionBar actionBar = getActionBar();
        actionBar.setTitle(intent.getStringExtra("name"));
        
        setupWebsite(intent.getStringExtra("website"));
        setupTwitter(intent.getStringExtra("twitter"));
	}
	
	private void setupWebsite(final String website) {
    	Button websiteView = (Button) findViewById(R.id.website);
        if (website != null) {
        	websiteView.setVisibility(View.VISIBLE);
        	websiteView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Intent i = new Intent(Intent.ACTION_VIEW);
					i.setData(Uri.parse("http://" + website));
					startActivity(i);
				}
        	});
        } else {
        	websiteView.setVisibility(View.GONE);
        }
	}
	
	private void setupTwitter(final String twitter) {
		Button twitterView = (Button) findViewById(R.id.twitter);
        if (twitter != null) {
        	twitterView.setVisibility(View.VISIBLE);
        	twitterView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Intent i = new Intent(Intent.ACTION_VIEW);
					i.setData(Uri.parse("https://twitter.com/" + twitter.substring(1)));
					startActivity(i);
				}
        	});
        } else {
        	twitterView.setVisibility(View.GONE);
        }
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		getListView().setOnItemClickListener(null);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Beer beer = (Beer) getListView().getItemAtPosition(position);
		
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle(beer.getName())
			   .setMessage("What did you think?")
		       .setPositiveButton("I Liked It", this)
		       .setNegativeButton("I Disliked It", this)
		       .setNeutralButton("Oops wrong beer", this)
		       .show();
	}

	@Override
	public void onClick(DialogInterface dialog, int which) {
		switch (which) {
		case DialogInterface.BUTTON_POSITIVE:
			break;
		case DialogInterface.BUTTON_NEGATIVE:
			break;
		case DialogInterface.BUTTON_NEUTRAL:
			break;
			
		}
	}
}
