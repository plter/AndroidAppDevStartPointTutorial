package com.plter.card2d;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {
	
	private RelativeLayout layout;
	private Card2D card;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		layout = (RelativeLayout) findViewById(R.id.layout);
		
		card = new Card2D(this);
		card.getRecto().setBackgroundResource(R.drawable.cat03);
		card.getVerso().setBackgroundResource(R.drawable.cat15);
		
		layout.addView(card, 200, 200);
		
		card.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (card.isRectoVisible()) {
//					card.showVerso();
					card.turnToVerso();
				}else{
//					card.showRecto();
					card.turnToRecto();
				}
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
