package com.plter.touchpoints;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {
	
	
	private RelativeLayout layout;
	private static final String TAG = "MainAty";
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		layout = (RelativeLayout) findViewById(R.id.layout);
		layout.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					Log.i(TAG,"down,pointer count:"+event.getPointerCount());
					break;
				case MotionEvent.ACTION_MOVE:
					Log.i(TAG,"move,pointer count:"+event.getPointerCount());
					
					if (event.getPointerCount()>=2) {
						Log.i(TAG, String.format("(x1:%s,y1:%s),(x2:%s,y2:%s)", event.getX(0),event.getY(0),event.getX(1),event.getY(1)));
					}
					
					break;
				case MotionEvent.ACTION_UP:
					Log.i(TAG,"up,pointer count:"+event.getPointerCount());
					break;

				default:
					break;
				}
				
				return true;
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
