package com.plter.chatclient;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.plter.chatclient.ChatService.OnConnectedListener;
import com.plter.chatclient.ChatService.OnDisconnectedListener;
import com.plter.chatclient.ChatService.OnIoErrorListener;
import com.plter.chatclient.ChatService.OnReceiveNewLineListener;
import com.plter.chatclient.ChatService.OnUnknownHostErrorListener;

public class MainActivity extends Activity {
	
	
	private EditText etUserNameInput,etInput;
	private TextView tvOut;
	private ChatService.Binder binder=null;
	private Button btnLogin=null;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		etInput = (EditText) findViewById(R.id.etInput);
		etUserNameInput = (EditText) findViewById(R.id.etUserNameInput);
		tvOut=(TextView) findViewById(R.id.tvOut);
		
		
		(btnLogin=(Button) findViewById(R.id.btnLogin)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (TextUtils.isEmpty(etUserNameInput.getText())) {
					Toast.makeText(MainActivity.this, "名字不能为空", Toast.LENGTH_SHORT).show();
					return;
				}
				
				setLoginFormEnabled(false);
				bindService(new Intent(MainActivity.this, ChatService.class), chatServiceConnection , BIND_AUTO_CREATE);
			}
		});
		
		findViewById(R.id.btnSend).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (TextUtils.isEmpty(etInput.getText())) {
					Toast.makeText(MainActivity.this, "请输入内容", Toast.LENGTH_SHORT).show();
					return;
				}
				
				if (binder!=null) {
					binder.sendLine(String.format("%s://%s", Headers.MSG,etInput.getText().toString()));
				}
			}
		});
	}
	
	
	@Override
	protected void onDestroy() {
		unbindService(chatServiceConnection);
		super.onDestroy();
	}
	
	protected ServiceConnection chatServiceConnection = new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			binder = (ChatService.Binder) service;
			binder.setOnConnectedListener(socketConnectedListener);
			binder.setOnIoErrorListener(socketIoErrorListener);
			binder.setOnUnknownHostErrorListener(socketUnknownHostErrorListener);
			binder.setOnDisconnectedListener(socketDisconnectedListener);
			binder.setOnReceiveNewLineListener(onReceiveNewLineListener);
			binder.connect("10.0.2.2", 8000);
		}
	};
	
	protected OnReceiveNewLineListener onReceiveNewLineListener=new OnReceiveNewLineListener() {
		
		@Override
		public void onReceive(String line) {
			
			String[] contents = line.split("://");
			if (contents.length==2) {
				String header = contents[0];
				if (header.equals(Headers.MSG)) {
					tvOut.setText(contents[1]+"\n"+tvOut.getText());
				}else if (header.equals(Headers.LOGIN)) {
					Toast.makeText(MainActivity.this, "用户 "+contents[1]+" 登陆了", Toast.LENGTH_SHORT).show();
				}else if (header.equals(Headers.LOGOUT)) {
					Toast.makeText(MainActivity.this, "用户 "+contents[1]+" 登出了", Toast.LENGTH_SHORT).show();
				}
			}
			
		}
	};
	
	private OnDisconnectedListener socketDisconnectedListener = new OnDisconnectedListener() {
		
		@Override
		public void onDisconnected() {
			setLoginFormEnabled(true);
		}
	};
	
	
	protected OnUnknownHostErrorListener socketUnknownHostErrorListener=new OnUnknownHostErrorListener() {
		
		@Override
		public void onUnknowHostError() {
			setLoginFormEnabled(true);
		}
	};
	
	
	protected OnIoErrorListener socketIoErrorListener=new OnIoErrorListener() {
		
		@Override
		public void onIoError() {
			setLoginFormEnabled(true);
		}
	};

	protected OnConnectedListener socketConnectedListener=new OnConnectedListener() {
		
		@Override
		public void onConnected() {
			if (binder!=null) {
				binder.login(etUserNameInput.getText().toString());
			}
		}
	};
	
	
	public void setLoginFormEnabled(boolean b){
		btnLogin.setEnabled(b);
		etUserNameInput.setEnabled(b);
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
