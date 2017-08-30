package com.plter.usingra;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;

public class MainActivity extends Activity {
	
	private Button rotateMe;
//	private RotateAnimation ra=new RotateAnimation(0, 360);
//	private RotateAnimation ra=new RotateAnimation(0, 360, 20, 20);
	private RotateAnimation ra=new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ra.setDuration(1000);
		
		rotateMe = (Button) findViewById(R.id.rotateMe);
		rotateMe.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				rotateMe.startAnimation(ra);
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
