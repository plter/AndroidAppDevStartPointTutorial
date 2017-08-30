package com.plter.usingframelayout;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {

	
	private ImageView img1,img2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		img1=(ImageView) findViewById(R.id.imageView1);
		img2=(ImageView) findViewById(R.id.imageView2);
		showImg1();
		
		findViewById(R.id.layout).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				changeImage();
			}
		});
	}
	
	
	private void changeImage(){
		if (img1.getVisibility()==View.VISIBLE) {
			showImg2();
		}else{
			showImg1();
		}
	}
	
	
	private void showImg2(){
		img1.setVisibility(View.GONE);
		img2.setVisibility(View.VISIBLE);
	}
	
	private void showImg1(){
		img1.setVisibility(View.VISIBLE);
		img2.setVisibility(View.GONE);
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
