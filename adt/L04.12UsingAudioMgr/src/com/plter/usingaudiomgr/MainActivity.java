package com.plter.usingaudiomgr;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {
	
	
	private AudioManager am;
	private OnClickListener clickListener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.btnNormal:
				am.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
				break;
			case R.id.btnSilent:
				am.setRingerMode(AudioManager.RINGER_MODE_SILENT);
				break;
			case R.id.btnVibrate:
				am.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
				break;
			default:
				break;
			}
		}
	};
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
		
		findViewById(R.id.btnNormal).setOnClickListener(clickListener);
		findViewById(R.id.btnSilent).setOnClickListener(clickListener);
		findViewById(R.id.btnVibrate).setOnClickListener(clickListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
