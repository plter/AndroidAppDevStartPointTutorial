package com.plter.chatserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChatThread extends Thread {

	public ChatThread(Socket socket) {
		this.socket=socket;
	}
	
	
	@Override
	public void run() {
		chatThreads.add(this);
		
		try {
			InputStream is = socket.getInputStream();
			os=socket.getOutputStream();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
			String line=null;
			while((line=br.readLine())!=null){
				sendToAll(line,this);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		chatThreads.remove(this);
		super.run();
	}
	
	public void send(String line){
		
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
	
	
	public static void sendToAll(String line,ChatThread except){
		ChatThread ct;
		
		for (int i = 0; i < chatThreads.size(); i++) {
			ct = chatThreads.get(i);
			if (ct!=except) {
				ct.send(line);
			}
		}
	}
	
	
	private OutputStream os=null;
	private Socket socket;
	private static final List<ChatThread> chatThreads = Collections.synchronizedList(new ArrayList<ChatThread>());

}
