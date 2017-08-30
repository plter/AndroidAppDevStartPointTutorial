package com.plter.usingcp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqlConn extends SQLiteOpenHelper {

	public SqlConn(Context context) {
		
		super(context, "UsingSqlite", null, 2);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
//		db.execSQL("CREATE TABLE user(" +
//				"name TEXT DEFAULT \"\"," +
//				"sex TEXT DEFAULT \"\"," +
//				"age TEXT DEFAULT \"\")");
		
		db.execSQL("CREATE TABLE user(" +
				"_id INTEGER PRIMARY KEY AUTOINCREMENT," +
				"name TEXT DEFAULT \"\"," +
				"sex TEXT DEFAULT \"\"," +
				"age TEXT DEFAULT \"\")");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS user");
		db.execSQL("CREATE TABLE user(" +
				"_id INTEGER PRIMARY KEY AUTOINCREMENT," +
				"name TEXT DEFAULT \"\"," +
				"sex TEXT DEFAULT \"\"," +
				"age TEXT DEFAULT \"\")");
	}

}
