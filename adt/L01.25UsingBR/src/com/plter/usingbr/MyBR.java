package com.plter.usingbr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyBR extends BroadcastReceiver {

	@Override
	public void onReceive(Context arg0, Intent arg1) {
		System.out.println("onReceive");
		System.out.println("Data is :"+arg1.getStringExtra("data"));
	}

}
