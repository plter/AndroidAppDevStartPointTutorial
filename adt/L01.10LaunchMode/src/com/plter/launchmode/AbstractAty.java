package com.plter.launchmode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class AbstractAty extends Activity{

	
	private TextView label;
	
	private OnClickListener btnClickHandler= new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.startSingleInstanceAtyBtn:
				startActivity(new Intent(AbstractAty.this, SingleInstanceAty.class));
				break;
			case R.id.startSingleTaskAtyBtn:
				startActivity(new Intent(AbstractAty.this, SingleTaskAty.class));
				break;
			case R.id.startSingleTopAtyBtn:
				startActivity(new Intent(AbstractAty.this, SingleTopAty.class));
				break;
			case R.id.startStandardAtyBtn:
				startActivity(new Intent(AbstractAty.this, StandardAty.class));
				break;
			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout);
		
		findViewById(R.id.startSingleInstanceAtyBtn).setOnClickListener(btnClickHandler);
		findViewById(R.id.startSingleTaskAtyBtn).setOnClickListener(btnClickHandler);
		findViewById(R.id.startSingleTopAtyBtn).setOnClickListener(btnClickHandler);
		findViewById(R.id.startStandardAtyBtn).setOnClickListener(btnClickHandler);
		
		
		//set aty label 
		label = (TextView) findViewById(R.id.label);
		label.setText(this.getClass().getName());
		
		
		Log.i(TAG, "Create Aty "+getClass().getName());
	}
	
	private static final String TAG="launchMode";
}
