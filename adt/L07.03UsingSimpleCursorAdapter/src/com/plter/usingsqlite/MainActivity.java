package com.plter.usingsqlite;

import android.app.ListActivity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends ListActivity {
	
	
	private SqlConn sqlConn;
	private SQLiteDatabase dbWrite,dbRead;
	private SimpleCursorAdapter sca;
	private EditText etName,etSex,etAge;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		etAge = (EditText) findViewById(R.id.etAge);
		etName = (EditText) findViewById(R.id.etName);
		etSex = (EditText) findViewById(R.id.etSex);
		
		
		sqlConn = new SqlConn(this);
		dbWrite = sqlConn.getWritableDatabase();
		dbRead = sqlConn.getReadableDatabase();
		
//		writeDb();
//		readDb();
		
		sca = new SimpleCursorAdapter(this, R.layout.user_list_cell, null, new String[]{"name","sex","age"}, new int[]{R.id.tvName,R.id.tvSex,R.id.tvAge});
		setListAdapter(sca);
		
		showUsers();
		
		findViewById(R.id.btnSave).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				save();
			}

		});
	}
	
	private void save() {
		
		ContentValues cv = new ContentValues();
		cv.put("name", etName.getText().toString());
		cv.put("sex", etSex.getText().toString());
		cv.put("age", etAge.getText().toString());
		
		dbWrite.insert("user", null, cv);
		
		showUsers();
	}
	
	private void showUsers(){
		sca.changeCursor(dbRead.query("user", new String[]{"_id","name","sex","age"}, null, null, null, null, null));
		
	}
	
	
	private void readDb(){
		
		Cursor cursor = dbRead.query("user", new String[]{"name","sex","age"}, "age=?", new String[]{"11"}, null, null, null);
		
		while(cursor.moveToNext()){
			System.out.println(String.format("name:%s,sex:%s,age:%s", getString("name", cursor),getString("sex", cursor),getString("age", cursor)));
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
	protected void onDestroy() {
		dbRead.close();
		dbWrite.close();
		super.onDestroy();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
