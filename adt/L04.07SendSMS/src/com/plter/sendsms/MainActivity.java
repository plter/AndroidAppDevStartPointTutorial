package com.plter.sendsms;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.telephony.SmsManager;
import android.text.BoringLayout;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	
	public static final String ACTION_SEND_SMS_BR="com.plter.sendsms.intent.action.SendSMSBr";
	
	private EditText etReceiverNum,etContent;
	
	private SmsManager sm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		etContent = (EditText) findViewById(R.id.etSmsContent);
		etReceiverNum = (EditText) findViewById(R.id.etReceiverNum);
		
		sm = SmsManager.getDefault();
		
		findViewById(R.id.btnSend).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ArrayList<String> strs = sm.divideMessage(etContent.getText().toString());
				for (String string : strs) {
					sm.sendTextMessage(etReceiverNum.getText().toString(), null, string, PendingIntent.getBroadcast(MainActivity.this, 1, new Intent(ACTION_SEND_SMS_BR), 0), null);
				}
			}
		});
	}
	
	
	private final BroadcastReceiver sendSmsReceiver = new BroadcastReceiver() {
		
		@Override
		public void onReceive(Context context, Intent intent) {
			switch (getResultCode()) {
			case RESULT_OK:
				Toast.makeText(MainActivity.this, "短信发送成功", Toast.LENGTH_SHORT).show();
				break;
			default:
				Toast.makeText(MainActivity.this, "短信发送失败", Toast.LENGTH_SHORT).show();
				break;
			}
		}
	};
	
	
	@Override
	protected void onResume() {
		registerReceiver(sendSmsReceiver,new IntentFilter(ACTION_SEND_SMS_BR));
		super.onResume();
	}
	
	
	@Override
	protected void onPause() {
		unregisterReceiver(sendSmsReceiver);
		super.onPause();
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
