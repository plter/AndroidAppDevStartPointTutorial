package com.plter.usingtabs;

import android.app.TabActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TabHost;

public class MainActivity extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		TabHost th = getTabHost();
		th.addTab(th.newTabSpec("tab1").setIndicator("tab1", getResources().getDrawable(android.R.drawable.ic_input_add)).setContent(R.id.tab1));
		th.addTab(th.newTabSpec("tab2").setIndicator("tab2").setContent(R.id.tab2));
		th.addTab(th.newTabSpec("tab3").setIndicator("tab3").setContent(R.id.tab3));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
