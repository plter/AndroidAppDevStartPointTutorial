package com.plter.usinglistview;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemClickListener {
	
	
	private ListView lv;
	private ArrayAdapter<ListCellData> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		adapter = new ArrayAdapter<ListCellData>(this, android.R.layout.simple_list_item_1);
//		adapter.add("北京");
//		adapter.add("上海");
//		adapter.add("广州");
//		adapter.add("深圳");
		adapter.add(new ListCellData("北京",10000));
		adapter.add(new ListCellData("上海",9000));
		
		lv=(ListView) findViewById(R.id.lv);
		lv.setAdapter(adapter);
		lv.setOnItemClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		ListCellData data = adapter.getItem(arg2);
		Toast.makeText(this, data.getLabel()+"，人数:"+data.getPeopleNum(), Toast.LENGTH_SHORT).show();
	}

}
