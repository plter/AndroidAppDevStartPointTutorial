package com.plter.startactivityandsendargs;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Aty extends Activity {

	
	private TextView tvOut;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.aty);
		
		tvOut=(TextView) findViewById(R.id.tvOut);
		
		String str = getIntent().getStringExtra("input");
		if (str!=null) {
			tvOut.setText(str);
		}
	}
	
}
