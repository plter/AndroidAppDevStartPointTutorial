package com.plter.usinglm;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity implements LocationListener {
	
	
	private LocationManager lm;
	private Location l;
	private TextView tv;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tv = (TextView) findViewById(R.id.tv);
		
		lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		l= lm.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);
		
		showLocation(l);
	}
	
	
	@Override
	protected void onResume() {
		
		lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 10, this);
		
		super.onResume();
	}
	
	
	@Override
	protected void onPause() {
		lm.removeUpdates(this);
		
		super.onPause();
	}
	
	
	private void showLocation(Location l){
		if (l==null) {
			return;
		}
		
		tv.setText("经度："+l.getLongitude()+",纬度："+l.getLatitude());
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


	@Override
	public void onLocationChanged(Location location) {
		showLocation(location);
	}


	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}

}
