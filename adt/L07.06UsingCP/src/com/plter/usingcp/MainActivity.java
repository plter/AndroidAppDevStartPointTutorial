package com.plter.usingcp;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
//		writeData();
		
		readData();
	}
	
	
	private void readData() {
		Cursor cursor = getContentResolver().query(MyCP.URI, null, null, null, null);
		
		while(cursor.moveToNext()){
			System.out.println(String.format("name=%s,sex=%s,age=%s", 
					cursor.getString(cursor.getColumnIndex(MyCP.NAME)),
					cursor.getString(cursor.getColumnIndex(MyCP.SEX)),
					cursor.getString(cursor.getColumnIndex(MyCP.AGE))
					));
		}
	}


	private void writeData(){
		for (int i = 0; i < 10; i++) {
			
			ContentValues cv = new ContentValues();
			cv.put(MyCP.NAME, "张三"+i);
			cv.put(MyCP.SEX, "男");
			cv.put(MyCP.AGE, 10+i+"");
			
			getContentResolver().insert(MyCP.URI, cv);
		}
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
