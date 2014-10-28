package com.zxb.guava3;

import com.google.common.eventbus.Subscribe;

public class EventListener {

	public int lastMessage=0;
	public int getLastMessage() {
		return lastMessage;
	}
	@Subscribe
	public void listen(TestEvent event){
		lastMessage=event.getMessage();
		System.out.println("Message:"+lastMessage);
	}
	
}
