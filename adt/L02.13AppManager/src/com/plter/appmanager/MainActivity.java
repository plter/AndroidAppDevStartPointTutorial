package com.plter.appmanager;

import java.util.List;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;

public class MainActivity extends ListActivity {

	
	private ActivityManager am;
	private ArrayAdapter<ListCellData> adapter;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		adapter=new ArrayAdapter<ListCellData>(this, android.R.layout.simple_list_item_1);
		
		am = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
		
		List<RunningAppProcessInfo> infos = am.getRunningAppProcesses();
		
		for (int i = 0; i < infos.size(); i++) {
			adapter.add(new ListCellData(infos.get(i)));
		}
		
		setListAdapter(adapter);
		
		findViewById(R.id.clearBtn).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				killAllRunningProcess();
			}
		});
	}
	
	
	private void killAllRunningProcess(){
		ListCellData data;
		
		for (int i = 0; i < adapter.getCount(); i++) {
			data = adapter.getItem(i);
			am.killBackgroundProcesses(data.getProcessName());
		}
		
		System.exit(0);
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
