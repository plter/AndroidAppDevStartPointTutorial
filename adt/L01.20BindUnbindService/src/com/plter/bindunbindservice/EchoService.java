package com.plter.bindunbindservice;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class EchoService extends Service {
	
//	public static final String ACTION="com.plter.startstopservice.intent.action.EchoService";
	
	private static final String TAG = EchoService.class.getSimpleName();

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public void onCreate() {
		Log.i(TAG, "onCreate");
		timer = new Timer();
		task = new TimerTask() {
			
			private int i=0;
			
			@Override
			public void run() {
				i++;
				System.out.println(i);
			}
		};
		timer.schedule(task, 1000, 1000);
		
		super.onCreate();
	}
	
	
	@Override
	public void onDestroy() {
		Log.i(TAG, "onDestory");
		
		timer.cancel();
		task.cancel();
		super.onDestroy();
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.i(TAG, "onStartCommand");
		return super.onStartCommand(intent, flags, startId);
	}
	
	private Timer timer=null;
	private TimerTask task=null;

}
