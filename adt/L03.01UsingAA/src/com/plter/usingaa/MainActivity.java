package com.plter.usingaa;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;

public class MainActivity extends Activity {
	
	
	private Button animMe;
	private AlphaAnimation aa=new AlphaAnimation(1, 0);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		aa.setDuration(1000);
//		aa.setFillAfter(true);
		
		animMe = (Button) findViewById(R.id.animMeBtn);
		animMe.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				animMe.startAnimation(aa);
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
