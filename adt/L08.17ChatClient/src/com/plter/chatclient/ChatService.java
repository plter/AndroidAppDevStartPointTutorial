package com.plter.chatclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.UnknownHostException;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;

public class ChatService extends Service {
	
	
	public static final String STATE_CONNECTED="connected";
	public static final String STATE_DISCONNECTED="disconnected";
	public static final String STATE_IO_ERROR="ioError";
	public static final String STATE_UNKNOWN_HOST_ERROR="unknownHostError";
	public static final String STATE_RECEIVE_NEW_LINE="receiveNewLine";


	@Override
	public IBinder onBind(Intent intent) {
		return binder;
	}
	
	
	@Override
	public void onDestroy() {
		if (socket!=null) {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		super.onDestroy();
	}
	

	private Socket socket=null;
	private OutputStream os=null;

	private void connect(final String host,final int port){
		if (socket!=null) {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		new AsyncTask<Void, String, Void>(){

			@Override
			protected Void doInBackground(Void... params) {

				try {
					socket = new Socket(host, port);

					os = socket.getOutputStream();
					InputStream is = socket.getInputStream();

					publishProgress(STATE_CONNECTED);
					
					BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
					String line = null;
					while((line=br.readLine())!=null){
						publishProgress(STATE_RECEIVE_NEW_LINE,line);
					}

					os = null;

					publishProgress(STATE_DISCONNECTED);

				} catch (UnknownHostException e) {
					e.printStackTrace();

					publishProgress(STATE_UNKNOWN_HOST_ERROR);
				} catch (IOException e) {
					e.printStackTrace();

					publishProgress(STATE_IO_ERROR);
				}

				return null;
			}
			
			
			protected void onProgressUpdate(String... values) {
				String state = values[0];
				
				if (state.equals(STATE_RECEIVE_NEW_LINE)) {
					if (binder.getOnReceiveNewLineListener()!=null) {
						binder.getOnReceiveNewLineListener().onReceive(values[1]);
					}
				}else if (state.equals(STATE_CONNECTED)) {
					if (binder.getOnConnectedListener()!=null) {
						binder.getOnConnectedListener().onConnected();
					}
				}else if (state.equals(STATE_DISCONNECTED)) {
					if (binder.getOnDisconnectedListener()!=null) {
						binder.getOnDisconnectedListener().onDisconnected();
					}
				}else if (state.equals(STATE_UNKNOWN_HOST_ERROR)) {
					if (binder.getOnUnknownHostErrorListener()!=null) {
						binder.getOnUnknownHostErrorListener().onUnknowHostError();
					}
				}else if (state.equals(STATE_IO_ERROR)) {
					if (binder.getOnIoErrorListener()!=null) {
						binder.getOnIoErrorListener().onIoError();
					}
				}
			};

		}.execute();

	}


	private void sendLine(String line){

		System.out.println(line+os);
		
		if (os!=null) {
			line+="\n";
			try {
				os.write(line.getBytes("utf-8"));
				os.flush();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


	private final Binder binder = new Binder();

	public class Binder extends android.os.Binder{

		public void connect(String host,int port){
			ChatService.this.connect(host, port);
		}

		public void sendLine(String line){
			ChatService.this.sendLine(line);
		}

		public void login(String username){
			sendLine(String.format("%s://%s", Headers.LOGIN,username));
		}

		public OnUnknownHostErrorListener getOnUnknownHostErrorListener() {
			return onUnknownHostErrorListener;
		}
		public void setOnUnknownHostErrorListener(
				OnUnknownHostErrorListener onUnknownHostErrorListener) {
			this.onUnknownHostErrorListener = onUnknownHostErrorListener;
		}

		public OnIoErrorListener getOnIoErrorListener() {
			return onIoErrorListener;
		}

		public void setOnIoErrorListener(OnIoErrorListener onIoErrorListener) {
			this.onIoErrorListener = onIoErrorListener;
		}

		public OnConnectedListener getOnConnectedListener() {
			return onConnectedListener;
		}

		public void setOnConnectedListener(OnConnectedListener onConnectedListener) {
			this.onConnectedListener = onConnectedListener;
		}

		public OnDisconnectedListener getOnDisconnectedListener() {
			return onDisconnectedListener;
		}

		public void setOnDisconnectedListener(OnDisconnectedListener onDisconnectedListener) {
			this.onDisconnectedListener = onDisconnectedListener;
		}

		public OnReceiveNewLineListener getOnReceiveNewLineListener() {
			return onReceiveNewLineListener;
		}

		public void setOnReceiveNewLineListener(OnReceiveNewLineListener onReceiveNewLineListener) {
			this.onReceiveNewLineListener = onReceiveNewLineListener;
		}

		private OnUnknownHostErrorListener onUnknownHostErrorListener=null;
		private OnIoErrorListener onIoErrorListener=null;
		private OnConnectedListener onConnectedListener=null;
		private OnDisconnectedListener onDisconnectedListener=null;
		private OnReceiveNewLineListener onReceiveNewLineListener=null;
	}


	public static interface OnUnknownHostErrorListener{
		void onUnknowHostError();
	}

	public static interface OnIoErrorListener{
		void onIoError();
	}

	public static interface OnConnectedListener{
		void onConnected();
	}

	public static interface OnDisconnectedListener{
		void onDisconnected();
	}

	public static interface OnReceiveNewLineListener{
		void onReceive(String line);
	}

}
