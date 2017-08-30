package com.plteractiivtylc;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class AtyB extends Activity {
	
	
	private static final String TAG=AtyB.class.getName();
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
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
