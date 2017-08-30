package com.plter.usingsqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQuery;

public class SqlConn extends SQLiteOpenHelper {

	public SqlConn(Context context) {
		
		super(context, "UsingSqlite", new SQLiteDatabase.CursorFactory() {
			
			@Override
			public Cursor newCursor(SQLiteDatabase db, SQLiteCursorDriver masterQuery,
					String editTable, SQLiteQuery query) {
				return new MySqliteCursor(db, masterQuery, editTable, query);
			}
		}, 2);
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
