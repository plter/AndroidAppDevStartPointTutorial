package com.plter.json;

import java.io.IOException;
import java.io.InputStream;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
//		readJson();
		
		JSONObject obj = new JSONObject();
		try {
			obj.put("name", "ZhangSan");
			obj.put("age", 18);
			
			System.out.println(obj.toString());
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
	}

	private void readJson() {
		InputStream in = getResources().openRawResource(R.raw.data);
		try {
			byte[] bytes = new byte[in.available()];
			in.read(bytes);
			
			String jsonStr = new String(bytes);
			
			JSONObject obj = new JSONObject(jsonStr);
			System.out.println(obj.getString("name"));
			
			JSONArray arr = obj.getJSONArray("arr");
			System.out.println(arr.length());
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
