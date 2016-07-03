package EventBus;

import com.google.common.eventbus.EventBus;

public class TestEventBus {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		EventBus eventBus=new EventBus("test");
		EventListener listener=new EventListener();
		eventBus.register(listener);
		
		eventBus.post(new TestEvent(200));
		eventBus.post(new TestEvent(300));
		eventBus.post(new TestEvent(400));
		
		System.out.println("LastMessage:"+listener.getLastMessage());
	}

}
