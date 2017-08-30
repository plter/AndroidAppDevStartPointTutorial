package com.plter.usingcontextmenu;

import android.os.Bundle;
import android.app.Activity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	
	private Button showCatsBtn,showDogsBtn;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		showCatsBtn = (Button) findViewById(R.id.showCatsBtn);
		registerForContextMenu(showCatsBtn);
		
		showDogsBtn = (Button) findViewById(R.id.showDogsBtn);
		registerForContextMenu(showDogsBtn);
	}
	
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		
		if (v == showCatsBtn) {
			menu.setHeaderTitle("选择猫");
			menu.add("黑猫");
			menu.add("白猫");
			menu.add("花猫");
		}else if(v==showDogsBtn){
			menu.setHeaderTitle("选择狗");
			menu.add("黑狗");
			menu.add("黄狗");
			menu.add("白狗");
			menu.add("花狗");
		}
		
		super.onCreateContextMenu(menu, v, menuInfo);
	}
	
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		
		Toast.makeText(this, "您选择的是："+item.getTitle(), Toast.LENGTH_SHORT).show();
		
		return super.onContextItemSelected(item);
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
