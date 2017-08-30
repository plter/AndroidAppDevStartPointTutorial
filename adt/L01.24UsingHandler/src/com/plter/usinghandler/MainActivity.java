package com.plter.usinghandler;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	
	private TextView tv;
	private Timer timer=new Timer();
	private TimerTask timerTask=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tv = (TextView) findViewById(R.id.tv);
		
	}
	
	
	@Override
	protected void onResume() {
		timerTask = new TimerTask() {
			
			@Override
			public void run() {
				handler.sendEmptyMessage(0);
			}
		};
		timer.schedule(timerTask, 100, 1000);
		super.onResume();
	}
	
	
	public void showTime(){
		Calendar c = Calendar.getInstance();
		
		String time = c.get(Calendar.HOUR_OF_DAY)+":"+c.get(Calendar.MINUTE)+":"+c.get(Calendar.SECOND);
//		System.out.println(time);
		tv.setText(time);
	}
	
	private Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			showTime();
		};
	};
	
	@Override
	protected void onPause() {
		timerTask.cancel();
		super.onPause();
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
