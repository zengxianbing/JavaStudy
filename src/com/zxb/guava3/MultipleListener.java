package com.zxb.guava3;

import com.google.common.eventbus.Subscribe;

public class MultipleListener {

	public Integer lastInteger;
	public Integer getLastInteger() {
		return lastInteger;
	}
	public Long getLastLong() {
		return lastLong;
	}
	public Long lastLong;
	
	@Subscribe
	public void listenInteger(Integer event){
		lastInteger=event;
		System.out.println("event Integer:"+lastInteger);
	}
	@Subscribe
	public void listenLong(Long event){
		lastLong=event;
		System.out.println("event Integer:"+lastLong);
	}
	
}