package com.plter.usingmina;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

public class MinaHandler extends IoHandlerAdapter {

	@Override
	public void sessionCreated(IoSession session) throws Exception {
		System.out.println("sessionCreated");
		super.sessionCreated(session);
	}
	
	@Override
	public void sessionOpened(IoSession session) throws Exception {
		System.out.println("sessionOpened");
		super.sessionOpened(session);
	}
	
	
	@Override
	public void sessionClosed(IoSession session) throws Exception {
		System.out.println("sessionClosed");
		super.sessionClosed(session);
	}
	
	
	@Override
	public void messageReceived(IoSession session, Object message)
			throws Exception {
		System.out.println("messageReceived");
		
		
		String str = (String) message;
		System.out.println(str);
		
		super.messageReceived(session, message);
	}
	
	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		super.messageSent(session, message);
	}

}
