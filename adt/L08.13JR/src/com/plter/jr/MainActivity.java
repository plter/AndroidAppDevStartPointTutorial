package com.plter.jr;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		JRServer s = new JRServer("http://10.0.2.2:8080/L08.13JR/index.jsp");
		s.setOnErrorListener(new JRServer.OnErrorListener() {
			
			@Override
			public void onError() {
				System.err.println("出错");
			}
		});
		s.setOnSuccessListener(new JRServer.OnSuccessListener() {
			
			@Override
			public void onSuccess(Object obj) {
				System.out.println(obj);
			}
		});
		
		s.call("hello", "plter");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
