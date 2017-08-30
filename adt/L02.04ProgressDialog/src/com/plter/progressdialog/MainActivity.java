package com.plter.progressdialog;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.app.ProgressDialog;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
	
	
	private static final int CLOSE_PD=1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		findViewById(R.id.showPd).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				pd = ProgressDialog.show(MainActivity.this, "正在加载", "正在加载数据，请稍候");
				handler.sendEmptyMessageDelayed(CLOSE_PD, 2000);
			}
		});
	}
	
	
	private ProgressDialog pd;
	
	private Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case CLOSE_PD:
				pd.dismiss();
				break;
			default:
				break;
			}
		};
	};
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
