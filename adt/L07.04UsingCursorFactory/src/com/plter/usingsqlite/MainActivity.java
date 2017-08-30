package com.plter.usingsqlite;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;

public class MainActivity extends Activity {
	
	
	private SqlConn sqlConn;
	private SQLiteDatabase dbWrite,dbRead;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		sqlConn = new SqlConn(this);
		dbWrite = sqlConn.getWritableDatabase();
		dbRead = sqlConn.getReadableDatabase();
		
//		writeDb();
		readDb();
	}
	
	
	private void readDb(){
		
		MySqliteCursor cursor = (MySqliteCursor) dbRead.query("user", new String[]{"name","sex","age"}, null, null, null, null, null);
		
		while(cursor.moveToNext()){
			System.out.println(String.format("name:%s,sex:%s,age:%s", cursor.getString("name"),cursor.getString("sex"),cursor.getString("age")));
		}
		
	}
	
	
	private String getString(String name,Cursor cursor){
		return cursor.getString(cursor.getColumnIndex(name));
	}


	private void writeDb() {
		for (int i = 0; i < 10; i++) {
			ContentValues cv = new ContentValues();
			cv.put("name", "张三 "+i);
			cv.put("sex", "男");
			cv.put("age", 10+i+"");
			
			dbWrite.insert("user", null, cv);
			
		}
		System.out.println("suc");
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
