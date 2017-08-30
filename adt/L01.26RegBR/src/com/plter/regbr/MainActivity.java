package com.plter.regbr;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {
	
	private MyBR br = new MyBR();

	private OnClickListener btnClickListener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.regBtn:
				registerReceiver(br, new IntentFilter("com.plter.regbr.intent.action.MyBR"));
				break;
			case R.id.unregBtn:
				unregisterReceiver(br);
				break;
			case R.id.sendBc:
				sendBroadcast(new Intent("com.plter.regbr.intent.action.MyBR"));
				break;
			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		findViewById(R.id.regBtn).setOnClickListener(btnClickListener);
		findViewById(R.id.unregBtn).setOnClickListener(btnClickListener);
		findViewById(R.id.sendBc).setOnClickListener(btnClickListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
