package com.iteye.designpatterns.memento;






class Original{
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Original(String value) {
		super();
		this.value = value;
	}
	
	public Memento createMemento(){
		return new Memento(value);
	}
	
	
	public void restoreMemento(Memento memento){
		this.value=memento.getValue();
	}
	
	
}

class Memento{
	private String value;

	public Memento(String value) {
		super();
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}





class Storage{
	private Memento memento;

	public Memento getMemento() {
		return memento;
	}

	public void setMemento(Memento memento) {
		this.memento = memento;
	}

	public Storage(Memento memento) {
		super();
		this.memento = memento;
	}
	
	
}



















public class MementoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		Original origi=new Original("egg");
		
		Storage storage=new Storage(origi.createMemento());
		
		

        // 修改原始类的状态  
        System.out.println("初始化状态为：" + origi.getValue());  
        origi.setValue("niu");  
        System.out.println("修改后的状态为：" + origi.getValue());  
  
        // 回复原始类的状态  
        origi.restoreMemento(storage.getMemento());  
        System.out.println("恢复后的状态为：" + origi.getValue());  
	}

}
