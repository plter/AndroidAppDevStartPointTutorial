package com.plter.helloserver;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class HelloThread extends Thread {


	public HelloThread(Socket socket) {
		this.socket=socket;
	}


	private Socket socket=null;


	@Override
	public void run() {

		try {
			OutputStream os = socket.getOutputStream();

			for (int i = 0; i < 30; i++) {
				try{
					os.write(String.format("Hello Client %d\n",i).getBytes());
					sleep(1000);
				}catch(Exception e){
					break;
				}
			}

			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.run();
	}

}
