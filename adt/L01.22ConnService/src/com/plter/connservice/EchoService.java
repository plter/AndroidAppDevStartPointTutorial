package com.plter.connservice;

import java.util.Timer;
import java.util.TimerTask;

import com.plter.aidls.IRemoteService;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class EchoService extends Service {
	
//	public static final String ACTION="com.plter.startstopservice.intent.action.EchoService";
	
	private static final String TAG = EchoService.class.getSimpleName();
	
	
//	public class EchoServiceBinder extends Binder{
//		
//		public int getIndex(){
//			return index;
//		}
//		
//	}
//	
//	private final EchoServiceBinder binder = new EchoServiceBinder();
	
	
	private IRemoteService.Stub binder = new IRemoteService.Stub() {
		
		@Override
		public int getIndex() throws RemoteException {
			return index;
		}
	};
	

	@Override
	public IBinder onBind(Intent intent) {
		return binder;
	}
	
	
	private int index = 0;
	
	@Override
	public void onCreate() {
		Log.i(TAG, "onCreate");
		timer = new Timer();
		task = new TimerTask() {
			
			@Override
			public void run() {
				index++;
				System.out.println(index);
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
