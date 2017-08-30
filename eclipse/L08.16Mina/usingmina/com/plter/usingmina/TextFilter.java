package com.plter.usingmina;

import java.nio.charset.Charset;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.filterchain.IoFilterAdapter;
import org.apache.mina.core.session.IoSession;

public class TextFilter extends IoFilterAdapter {

	@Override
	public void messageReceived(NextFilter nextFilter, IoSession session,
			Object message) throws Exception {
		
		IoBuffer buf = (IoBuffer) message;
		
		super.messageReceived(nextFilter, session, buf.getString(Charset.forName("utf-8").newDecoder()));
	}
	
}
