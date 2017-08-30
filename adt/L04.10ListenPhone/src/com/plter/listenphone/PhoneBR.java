package com.plter.listenphone;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class PhoneBR extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
//		System.out.println(intent.getExtras().keySet());
		
		String state = intent.getExtras().getString("state");
		String incoming_number = intent.getExtras().getString("incoming_number");
		
		System.out.println("state:"+state+",number:"+incoming_number);
		
	}

}
