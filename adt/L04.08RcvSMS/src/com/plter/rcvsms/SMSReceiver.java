package com.plter.rcvsms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

public class SMSReceiver extends BroadcastReceiver {
	

	@Override
	public void onReceive(Context context, Intent intent) {
		
		Bundle data = intent.getExtras();
		
		if (data==null) {
			return;
		}
		
		Object[] objs = (Object[]) data.get("pdus");
		
		SmsMessage smsMessage;
		for (Object object : objs) {
			byte[] bytes = (byte[]) object;
			
			smsMessage = SmsMessage.createFromPdu(bytes);
			
			System.out.println("发送者号码："+smsMessage.getOriginatingAddress()+",消息内容："+smsMessage.getMessageBody());
		}
		
	}

}
