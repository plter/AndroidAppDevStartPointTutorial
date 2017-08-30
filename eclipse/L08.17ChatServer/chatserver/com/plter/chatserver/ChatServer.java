package com.plter.chatserver;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

public class ChatServer {

	
	public static void main(String[] args) {
		NioSocketAcceptor acceptor = new NioSocketAcceptor();
		acceptor.getFilterChain().addLast("textCodec", new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("utf-8"))));
		acceptor.setHandler(new ChatHandler());
		try {
			acceptor.bind(new InetSocketAddress(8000));
			System.out.println("Server started at port 8000");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
