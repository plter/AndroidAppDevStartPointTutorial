package com.plter.usingnotify;

import android.os.Bundle;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	
	private NotificationManager nm;


	private EditText etTickerText,etNotificationTitle,etNotificationContent;
	private OnClickListener btnClickListener=new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.btnShowNotification:
				
				Notification n = new Notification(android.R.drawable.ic_input_add, etTickerText.getText(), System.currentTimeMillis());
				n.setLatestEventInfo(MainActivity.this, 
						etNotificationTitle.getText(), 
						etNotificationContent.getText(), 
						PendingIntent.getActivity(MainActivity.this, 
								0, 
								getIntent(), 
								PendingIntent.FLAG_UPDATE_CURRENT
						)
					);
				
				nm.notify(R.layout.activity_main, n);
				break;
			case R.id.btnClearNotification:
//				nm.cancel(R.layout.activity_main);
				nm.cancelAll();
				break;
			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

		etTickerText = (EditText) findViewById(R.id.etTickerText);
		etNotificationContent = (EditText) findViewById(R.id.etNotificationContent);
		etNotificationTitle = (EditText) findViewById(R.id.etNotificationTitle);

		findViewById(R.id.btnShowNotification).setOnClickListener(btnClickListener);
		findViewById(R.id.btnClearNotification).setOnClickListener(btnClickListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
