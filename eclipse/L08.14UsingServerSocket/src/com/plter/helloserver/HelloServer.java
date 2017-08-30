package com.plter.helloserver;

import java.io.IOException;
import java.net.ServerSocket;

public class HelloServer {




	public static void main(String[] args) {

		try {
			ServerSocket ss = new ServerSocket(8000);

			System.out.println("Server listening port 8000");

			while(true){
				new HelloThread(ss.accept()).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
