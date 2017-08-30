package com.plter.usingrelativelayout;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class MainActivity extends Activity {
	
	
	private RelativeLayout layout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		layout = (RelativeLayout) findViewById(R.id.layout);
		
		
		RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(-2,-2);
		lp.leftMargin=100;
		
		Button btn = new Button(this);
		btn.setText("Click me");
		layout.addView(btn,lp);
		
//		RelativeLayout.LayoutParams lp = (LayoutParams) btn.getLayoutParams();
//		lp.leftMargin=100;
//		btn.setLayoutParams(lp);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
