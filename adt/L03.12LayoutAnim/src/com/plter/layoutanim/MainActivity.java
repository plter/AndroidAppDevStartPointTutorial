package com.plter.layoutanim;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.animation.LayoutAnimationController;
import android.view.animation.ScaleAnimation;
import android.widget.ArrayAdapter;

public class MainActivity extends ListActivity {
	
	private LayoutAnimationController lac;
	private ScaleAnimation sa = new ScaleAnimation(0, 1, 0, 1);
	
	private ArrayAdapter<String> adapter;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		sa.setDuration(1000);
		
		adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
		for (int i = 0; i < 10; i++) {
			adapter.add("Item "+1);
		}
		setListAdapter(adapter);
		
		lac = new LayoutAnimationController(sa);
		lac.setDelay(0.3f);
		lac.setOrder(LayoutAnimationController.ORDER_RANDOM);
		getListView().setLayoutAnimation(lac);
		
		findViewById(R.id.startLaBtn).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				getListView().startLayoutAnimation();
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
