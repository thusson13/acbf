package com.acbf;

import com.acbf.provider.ACBFProvider.BeerColumns;

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
		int id = intent.getIntExtra("brewer_id", -1);
        
        Cursor cursor = getContentResolver().query(Uri.parse("content://com.acbf.provider/brewery/" + id), null, null, null, null);
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
        	twitterView.setText(twitter);
        	twitterView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Intent i = new Intent(Intent.ACTION_VIEW);
					i.setData(Uri.parse("https://twitter.com/" + twitter));
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
		Cursor c = (Cursor) getListView().getItemAtPosition(position);
		
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle(c.getString(c.getColumnIndex(BeerColumns.NAME)))
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
