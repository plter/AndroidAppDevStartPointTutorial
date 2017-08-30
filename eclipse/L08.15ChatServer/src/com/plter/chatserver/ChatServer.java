package com.plter.chatserver;

import java.io.IOException;
import java.net.ServerSocket;

public class ChatServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(8000);
			System.out.println("Server start at port 8000");
			
			while(true){
				new ChatThread(ss.accept()).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
