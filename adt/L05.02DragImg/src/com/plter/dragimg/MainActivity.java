package com.plter.dragimg;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {
	
	
	private ImageView img;
	private RelativeLayout layout;
	private RelativeLayout.LayoutParams imgLp;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		img = (ImageView) findViewById(R.id.img);
		layout=(RelativeLayout) findViewById(R.id.layout);
		
		layout.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				
				if (event.getAction()==MotionEvent.ACTION_MOVE) {
					
					imgLp = (RelativeLayout.LayoutParams)img.getLayoutParams();
					imgLp.leftMargin=(int) event.getX();
					imgLp.topMargin=(int) event.getY();
					img.setLayoutParams(imgLp);
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
