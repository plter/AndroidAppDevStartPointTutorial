package com.plter.addappwidgetsconfig;

import android.app.Activity;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RemoteViews;

public class MainActivity extends Activity {
	
	
	private EditText etInput;
	private AppWidgetManager awm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		awm = AppWidgetManager.getInstance(this);
		
		etInput = (EditText) findViewById(R.id.etInput);
		
		findViewById(R.id.btnOk).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				String input = etInput.getText().toString();
				
				RemoteViews rv = new RemoteViews(getPackageName(), R.layout.my_aw_layout);
				rv.setTextViewText(R.id.btn, input);
				Intent in = new Intent(MainActivity.this, AppWidgetButtonClickBcr.class);
				rv.setOnClickPendingIntent(R.id.btn, PendingIntent.getBroadcast(MainActivity.this, 0, in, PendingIntent.FLAG_UPDATE_CURRENT));
				
				Bundle b = getIntent().getExtras();
				int appWidgetId = b.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID);
				
				awm.updateAppWidget(appWidgetId, rv);
				
				Intent i = new Intent();
				i.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);
				
				setResult(RESULT_OK, i);
				finish();
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
