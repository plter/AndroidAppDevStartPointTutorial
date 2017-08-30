package com.plter.playsound;

import java.io.IOException;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {
	
	
	private MediaPlayer mp;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		findViewById(R.id.btnStop).setOnClickListener(btnClickListener);
		findViewById(R.id.btnPause).setOnClickListener(btnClickListener);
		findViewById(R.id.btnPlay).setOnClickListener(btnClickListener);
	}
	
	private OnClickListener btnClickListener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.btnPlay:
				mp.start();
				break;
			case R.id.btnPause:
				mp.pause();
				break;
			case R.id.btnStop:
				mp.pause();
				mp.seekTo(0);
				
//				mp.stop();
//				try {
//					mp.prepare();
//				} catch (IllegalStateException e) {
//					e.printStackTrace();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
				break;
			default:
				break;
			}
		}
	};
	
	@Override
	protected void onResume() {
		mp = MediaPlayer.create(this, R.raw.sound);
		super.onResume();
	}
	
	
	@Override
	protected void onPause() {
		mp.release();
		super.onPause();
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
