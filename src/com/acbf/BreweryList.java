package com.acbf;

import com.acbf.data.Brewer;
import com.acbf.provider.ACBFProvider.BreweryColumns;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;

public class BreweryList extends ListActivity implements OnItemClickListener {
	@Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        // We'll define a custom screen layout here (the one shown above), but
        // typically, you could just use the standard ListActivity layout.
        setContentView(R.layout.brewer_list);

        Cursor cursor = getContentResolver().query(Uri.parse("content://com.acbf.provider/brewery"), null, null, null, null);

        ListAdapter adapter = new BreweryAdapter(this, cursor);

        // Bind to our new adapter.
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Intent intent = new Intent();
		intent.setClass(this, BeerList.class);
		
		Cursor c = (Cursor) getListView().getItemAtPosition(position);
		intent.putExtra("brewer_id", c.getInt(c.getColumnIndex(BreweryColumns._ID)));
		intent.putExtra("name", c.getString(c.getColumnIndex(BreweryColumns.NAME)));
		String twitter = c.getString(c.getColumnIndex(BreweryColumns.TWITTER));
		if (!TextUtils.isEmpty(twitter)) {
			intent.putExtra("twitter", twitter);
		}
		startActivity(intent);
	}
}
