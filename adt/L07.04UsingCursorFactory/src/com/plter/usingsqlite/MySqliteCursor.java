package com.plter.usingsqlite;

import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;

public class MySqliteCursor extends SQLiteCursor {

	public MySqliteCursor(SQLiteDatabase db, SQLiteCursorDriver driver,
			String editTable, SQLiteQuery query) {
		super(db, driver, editTable, query);
	}
	
	
	public String getString(String name){
		return getString(getColumnIndex(name));
	}

}
