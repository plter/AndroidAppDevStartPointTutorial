package com.plter.usinggallery;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class MainActivity extends Activity {


	private Gallery gallery;
	private BaseAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		adapter = new BaseAdapter() {


			private int[] imgIds = {
					R.drawable.cat1,R.drawable.cat2,R.drawable.cat3,
					R.drawable.cat4,R.drawable.cat5,R.drawable.cat6
			};

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				
				ImageView iv;
				if (convertView==null) {
					iv = new ImageView(MainActivity.this);
					iv.setLayoutParams(new Gallery.LayoutParams(150, 100));
					iv.setScaleType(ScaleType.FIT_CENTER);
				}else{
					iv = (ImageView) convertView;
				}
				
				iv.setImageResource(imgIds[position]);
				
				return iv;
			}

			@Override
			public long getItemId(int position) {
				return position;
			}

			@Override
			public Object getItem(int position) {
				return imgIds[position];
			}

			@Override
			public int getCount() {
				return imgIds.length;
			}
		};

		gallery = (Gallery) findViewById(R.id.gallery);
		gallery.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
