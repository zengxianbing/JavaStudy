package com.zxb.guava3;

import org.junit.Test;

import com.google.common.eventbus.EventBus;

public class TestMultipleEvents {

	
	@Test
	public void testMultipleEvents(){
		EventBus eventBus=new EventBus("test");
		MultipleListener multiListener=new MultipleListener();
		eventBus.register(multiListener);
		
		eventBus.post(new Integer(100));
		eventBus.post(new Integer(200));
		eventBus.post(new Integer(300));
		eventBus.post(new Integer(800));
		eventBus.post(new Integer(800990));
		eventBus.post(new Integer(800882934));

       System.out.println("LastInteger:"+multiListener.getLastInteger());
       System.out.println("LastLong:"+multiListener.getLastLong());
		
		
		
	}
}
