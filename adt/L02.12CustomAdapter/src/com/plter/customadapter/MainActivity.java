package com.plter.customadapter;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends ListActivity {
	
	
	private ImageAdapter imageAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		findViewById(R.id.removeBtn).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				removeFirst();
			}
		});
		
		
		imageAdapter = new ImageAdapter(this);
		setListAdapter(imageAdapter);
		
		imageAdapter.add(new ImageListCellData("Cat", R.drawable.cat));
		imageAdapter.add(new ImageListCellData("Cat 1", R.drawable.cat1));
		imageAdapter.add(new ImageListCellData("Cat 2", R.drawable.cat2));
		imageAdapter.add(new ImageListCellData("Cat 3", R.drawable.cat3));
		imageAdapter.add(new ImageListCellData("Cat 4", R.drawable.cat4));
		imageAdapter.add(new ImageListCellData("Cat 5", R.drawable.cat5));
		imageAdapter.add(new ImageListCellData("Cat 6", R.drawable.cat6));
		imageAdapter.add(new ImageListCellData("Dog", R.drawable.dog));
		imageAdapter.add(new ImageListCellData("White Dog", R.drawable.white_dog));
	}
	
	
	private void removeFirst(){
		imageAdapter.remove(0);
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
