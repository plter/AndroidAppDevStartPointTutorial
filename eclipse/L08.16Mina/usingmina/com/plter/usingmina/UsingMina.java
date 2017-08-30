package com.plter.usingmina;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

public class UsingMina {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NioSocketAcceptor acceptor = new NioSocketAcceptor();
		
		acceptor.getFilterChain().addLast("TextFilter", new TextFilter());
		acceptor.setHandler(new MinaHandler());
		try {
			acceptor.bind(new InetSocketAddress(8000));
			System.out.println("Server started at port 8000");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
