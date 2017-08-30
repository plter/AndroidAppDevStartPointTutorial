package com.plter.usingsp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class MainActivity extends Activity {
	
	
	
	private SharedPreferences sp;
	private Editor editor;
	
	private CheckBox cb;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		cb = (CheckBox) findViewById(R.id.checkBox1);
		
		sp = getSharedPreferences("sp", Context.MODE_PRIVATE);
		editor=sp.edit();
		
		cb.setChecked(sp.getBoolean("checked", false));
		
		cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				editor.putBoolean("checked", isChecked);
				editor.commit();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
