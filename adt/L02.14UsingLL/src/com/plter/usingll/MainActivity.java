package com.plter.usingll;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
	
	
	private LinearLayout layout;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		layout = (LinearLayout) findViewById(R.id.layout);
		
		Button btn = new Button(this);
		btn.setText("Click me");
		layout.addView(btn, -2, -2);
//		layout.addView(btn, new LinearLayout.LayoutParams(-2, -2));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
