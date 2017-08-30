package com.plter.usinglistactivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class MainActivity extends ListActivity {

	
	private ArrayAdapter<String> adapter;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
		adapter.add("Hello");
		adapter.add("World");
		
		setListAdapter(adapter);
	}


}
