package EventBus;

public class TestEvent {

	private final int message;

	public TestEvent(int message) {
		//super();
		this.message = message;
		System.out.println("event message:"+message);
	}
	
	public int getMessae(){
		return message;
	}
	
}
