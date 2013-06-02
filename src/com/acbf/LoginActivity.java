 package com.acbf;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LoginActivity extends Activity implements OnClickListener {

	private static boolean registered = false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		Button register = (Button) findViewById(R.id.submitButton);
		register.setOnClickListener(this);
		
		if (registered) {
			startActivity(new Intent(this, BrewersList.class));
		}
	}

	@Override
	public void onClick(View v) {
		registered = true;
		startActivity(new Intent(this, BrewersList.class));
	}
}
