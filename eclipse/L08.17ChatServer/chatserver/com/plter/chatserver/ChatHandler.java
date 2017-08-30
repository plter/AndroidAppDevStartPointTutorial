package com.plter.chatserver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

public class ChatHandler extends IoHandlerAdapter {

	/* 
	 * 登陆 login://username
	 * 登出 logout://username
	 * 聊天信息 msg://hello
	 */



	@Override
	public void messageReceived(IoSession session, Object message)
			throws Exception {

		String line = (String) message;
		
		System.out.println(line);
		
		String[] contents = line.split("://");
		if (contents.length==2) {
			String header = contents[0];
			if (header.equals(Headers.MSG)) {
				String msg = contents[1];
				String userName = (String) session.getAttribute("userName", "noname");
				sendToAll(String.format("%s://%s:%s",Headers.MSG,userName,msg));
			}else if (header.equals(Headers.LOGIN)) {
				String userName = contents[1];
				session.setAttribute("userName", userName);

				if (!sessions.contains(session)) {
					sessions.add(session);
				}
				
				sendToAll(line);
			}
		}


		super.messageReceived(session, message);
	}


	@Override
	public void sessionCreated(IoSession session) throws Exception {
		//		sessions.add(session);
		super.sessionCreated(session);
	}


	@Override
	public void sessionClosed(IoSession session) throws Exception {
		sessions.remove(session);
		
		String userName = (String) session.getAttribute("userName", "noname");
		sendToAll(String.format("%s://%s", Headers.LOGOUT,userName));
		
		super.sessionClosed(session);
	}


	public void sendToAll(String line){
		synchronized (sessions) {
			for (IoSession session : sessions) {
				session.write(line);
			}
		}
	}


	private static List<IoSession> sessions = Collections.synchronizedList(new ArrayList<IoSession>());

}
