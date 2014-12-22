package com.netty.handler;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

public class TimeClientHandler extends SimpleChannelHandler {

	@Override
	public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
		ChannelBuffer buf = (ChannelBuffer) e.getMessage();
		while (buf.readable()) {
			System.out.println((char) buf.readByte());
			System.out.flush();
		}
		// Channel ch = e.getChannel();
		// ch.write(e);
	}

	@Override
	public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
//		Channel ch = e.getChannel();
//		ChannelBuffer time = ChannelBuffers.buffer(4);
//		time.writeChar(97);
//		ChannelFuture f = ch.write(time);
//		f.addListener(new ChannelFutureListener() {
//			public void operationComplete(ChannelFuture future) {
//				Channel ch = future.getChannel();
//				System.out.println(ch.getRemoteAddress().toString());
//				ch.close();
//			}
//
//		});
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
		e.getCause().printStackTrace();
		Channel ch = e.getChannel();
		ch.close();
	}

	@Override
	public void handleDownstream(ChannelHandlerContext arg0, ChannelEvent arg1) throws Exception {
		// TODO Auto-generated method stub
		super.handleDownstream(arg0, arg1);
	}

	@Override
	public void handleUpstream(ChannelHandlerContext arg0, ChannelEvent arg1) throws Exception {
		// TODO Auto-generated method stub
		super.handleUpstream(arg0, arg1);
	}

}
