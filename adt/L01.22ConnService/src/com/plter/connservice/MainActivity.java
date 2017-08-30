package com.plter.connservice;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

import com.plter.aidls.IRemoteService;
import com.plter.aidls.IRemoteService.Stub;

public class MainActivity extends Activity {
	
	
	private IRemoteService.Stub binder=null;

	protected ServiceConnection serviceConn=new ServiceConnection() {
		
		private final String TAG=ServiceConnection.class.getSimpleName();
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			Log.w(TAG, "onServiceDisconnected");
			
			binder=null;
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			Log.i(TAG, "onServiceConnected");
			
			binder = (Stub) service;
		}
	};
	
	private OnClickListener btnClickListener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.bindServiceBtn:
				bindService(new Intent(MainActivity.this, EchoService.class), serviceConn, BIND_AUTO_CREATE);
				break;
			case R.id.unbindServiceBtn:
				unbindService(serviceConn);
				binder=null;
				break;
			case R.id.getIndexBtn:
				if (binder!=null) {
					try {
						System.out.println("当前index的值是："+binder.getIndex());
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				}
				break;
			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		findViewById(R.id.bindServiceBtn).setOnClickListener(btnClickListener);
		findViewById(R.id.unbindServiceBtn).setOnClickListener(btnClickListener);
		findViewById(R.id.getIndexBtn).setOnClickListener(btnClickListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
