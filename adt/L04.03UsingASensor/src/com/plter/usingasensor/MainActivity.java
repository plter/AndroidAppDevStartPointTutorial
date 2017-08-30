package com.plter.usingasensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity implements SensorEventListener {
	
	
	private SensorManager sm;
	private Sensor s;
	private static final String TAG = "MainAty";
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		s = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		
		
	}
	
	
	@Override
	protected void onResume() {
		sm.registerListener(this, s, SensorManager.SENSOR_DELAY_NORMAL);
		super.onResume();
	}
	
	
	@Override
	protected void onPause() {
		sm.unregisterListener(this);
		super.onPause();
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


	@Override
	public void onSensorChanged(SensorEvent event) {
		Log.i(TAG, "x:"+event.values[0]+",y:"+event.values[1]+",z:"+event.values[2]);
	}


	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}

}
