package com.plter.usinggrid;

import com.plter.usinggrad.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends Activity {
	
	
	private GridView gridView;
	private BaseAdapter adapter;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		adapter = new BaseAdapter() {
			
			
			private int[] imgsIds = {
					R.drawable.cat01,
					R.drawable.cat02,
					R.drawable.cat03,
					R.drawable.cat04,
					R.drawable.cat05,
					R.drawable.cat06,
					R.drawable.cat07,
					R.drawable.cat08,
					R.drawable.cat09,
					R.drawable.cat10,
					R.drawable.cat11,
					R.drawable.cat12,
					R.drawable.cat13,
					R.drawable.cat14,
					R.drawable.cat15
			};
			
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				
				ImageView iv ;
				if (convertView==null) {
					iv = new ImageView(MainActivity.this);
				}else{
					iv=(ImageView) convertView;
				}
				
				iv.setImageResource(imgsIds[position]);
				
				return iv;
			}
			
			@Override
			public long getItemId(int position) {
				return position;
			}
			
			@Override
			public Object getItem(int position) {
				return imgsIds[position];
			}
			
			@Override
			public int getCount() {
				return imgsIds.length;
			}
		};
		
		
		gridView = (GridView) findViewById(R.id.grid);
		gridView.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
