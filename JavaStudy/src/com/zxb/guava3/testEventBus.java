package com.zxb.guava3;

import org.junit.Test;

import com.google.common.eventbus.EventBus;

public class testEventBus {

	@Test
	public void testReceiveEvent(){
		EventBus eventBus=new EventBus("test");
		EventListener listener=new EventListener();
		
		eventBus.register(listener);
		
		eventBus.post(new TestEvent(200));
		eventBus.post(new TestEvent(300));
		eventBus.post(new TestEvent(400));
		eventBus.post(new TestEvent(500));
		
		System.out.println("LastMessage:"+listener.getLastMessage());
	}
}
