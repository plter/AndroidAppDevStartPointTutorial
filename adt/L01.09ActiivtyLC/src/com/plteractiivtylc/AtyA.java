package com.plteractiivtylc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class AtyA extends Activity {

	
	private static final String TAG=AtyA.class.getName();
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.aty_a);
		
		findViewById(R.id.startBBtn).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(AtyA.this, AtyB.class));
			}
		});
		
		Log.i(TAG, "onCreate");
	}
	
	@Override
	protected void onStart() {
		Log.i(TAG, "onStart");
		super.onStart();
	}
	
	@Override
	protected void onResume() {
		Log.i(TAG, "onResume");
		super.onResume();
	}
	
	@Override
	protected void onPause() {
		Log.i(TAG, "onPause");
		super.onPause();
	}
	
	@Override
	protected void onStop() {
		Log.i(TAG, "onStop");
		super.onStop();
	}
	
	@Override
	protected void onDestroy() {
		Log.i(TAG, "onDestory");
		super.onDestroy();
	}
	
	@Override
	protected void onRestart() {
		Log.i(TAG, "onRestart");
		super.onRestart();
	}
}
