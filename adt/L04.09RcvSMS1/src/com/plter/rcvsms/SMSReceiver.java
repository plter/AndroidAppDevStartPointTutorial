package com.plter.rcvsms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SMSReceiver extends BroadcastReceiver {
	
	// pltertoast:msg

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
			
			
			String sms = smsMessage.getMessageBody();
			String[] strs = sms.split(":");
			if (strs.length==2) {
				if ("pltertoast".equalsIgnoreCase(strs[0])) {
					Toast.makeText(context, strs[1], Toast.LENGTH_SHORT).show();
					abortBroadcast();
				}
			}
		}
		
		
//		abortBroadcast();
	}

}
