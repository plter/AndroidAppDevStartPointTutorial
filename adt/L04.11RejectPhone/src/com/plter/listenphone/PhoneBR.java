package com.plter.listenphone;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;

public class PhoneBR extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
//		System.out.println(intent.getExtras().keySet());
		
		String state = intent.getExtras().getString("state");
		String incoming_number = intent.getExtras().getString("incoming_number");
		
//		System.out.println("state:"+state+",number:"+incoming_number);
		
		if ("10086".equals(incoming_number)) {
			
			TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
			
			try {
				Method getITelephonyMethod = TelephonyManager.class.getDeclaredMethod("getITelephony");
				getITelephonyMethod.setAccessible(true);
				Object telephony = getITelephonyMethod.invoke(tm);
				Method endCallMethod = telephony.getClass().getMethod("endCall");
				endCallMethod.invoke(telephony);
				
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
