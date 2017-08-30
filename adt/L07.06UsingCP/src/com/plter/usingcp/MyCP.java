package com.plter.usingcp;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class MyCP extends ContentProvider {
	
	
	public static final Uri URI = Uri.parse("content://com.plter.usingcp.provider.MyCP");

	
	private SqlConn sqlConn;
	private SQLiteDatabase dbRead,dbWrite;
	
	public static final String TABLE_NAME="user";
	public static final String NAME="name";
	public static final String SEX="sex";
	public static final String AGE="age";
	
	@Override
	public boolean onCreate() {
		sqlConn = new SqlConn(getContext());
		dbRead = sqlConn.getReadableDatabase();
		dbWrite = sqlConn.getWritableDatabase();
		return true;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		return dbRead.query(TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
	}

	@Override
	public String getType(Uri uri) {
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		dbWrite.insert(TABLE_NAME, null, values);
		return uri;
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		return dbWrite.delete(TABLE_NAME, selection, selectionArgs);
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		return dbWrite.update(TABLE_NAME, values, selection, selectionArgs);
	}

}
