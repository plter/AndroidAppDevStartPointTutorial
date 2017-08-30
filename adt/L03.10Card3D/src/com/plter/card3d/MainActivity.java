package com.plter.card3d;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

	
	
	private RelativeLayout layout;
	private Card3D card3d;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		layout = (RelativeLayout) findViewById(R.id.layout);
		
		card3d = new Card3D(this);
		card3d.getRecto().setBackgroundResource(R.drawable.cat01);
		card3d.getVerso().setBackgroundResource(R.drawable.cat02);
		card3d.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (card3d.isRectoVisible()) {
					card3d.turnToVerso();
				}else{
					card3d.turnToRecto();
				}
			}
		});
		
		layout.addView(card3d, 200, 200);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
