package com.plter.readcpfromotherapp;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		readData();
	}
	
	
	private void readData() {
		Cursor cursor = getContentResolver().query(Uri.parse("content://com.plter.usingcp.provider.MyCP"), null, null, null, null);
		
		while(cursor.moveToNext()){
			System.out.println(String.format("name=%s,sex=%s,age=%s", 
					cursor.getString(cursor.getColumnIndex("name")),
					cursor.getString(cursor.getColumnIndex("sex")),
					cursor.getString(cursor.getColumnIndex("age"))
					));
		}
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
