package com.example.usinguicontrols;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

	
	private LinearLayout layout;
//	private OnClickListener btnClickListener=new OnClickListener() {
//		
//		@Override
//		public void onClick(View v) {
//			layout.removeView(v);
//		}
//	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		layout = (LinearLayout) findViewById(R.id.main);
//		Button btn;
		
//		for (int i = 0; i < 5; i++) {
//			btn= new Button(this);
//			btn.setText("Button "+i);
////			layout.addView(btn);
////			layout.addView(btn, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
//			layout.addView(btn, -2, -2);
//			
//			btn.setOnClickListener(btnClickListener);
//		}
		
//		PButton btn = new PButton(this);
//		btn.setText("Remove me");
//		layout.addView(btn);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
