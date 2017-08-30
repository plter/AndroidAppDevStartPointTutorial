package com.plter.usinganimation;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

public class MainActivity extends Activity {
	
	
	private Button btn;
	private AnimationSet as=new AnimationSet(true);
	private AlphaAnimation aa = new AlphaAnimation(1, 0);
	private TranslateAnimation ta = new TranslateAnimation(0, 300, 0, 600);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		as.addAnimation(ta);
		as.addAnimation(aa);
		
		as.setDuration(10000);
		as.setInterpolator(new AccelerateInterpolator());
		
		btn = (Button) findViewById(R.id.animMe);
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				btn.startAnimation(as);
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
