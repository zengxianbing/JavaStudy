package com.iteye.designpatterns.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Prototype {

	private static final long serialVersionUID=1l;
	
	private String string;
	
	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public SerializableObject getObj() {
		return obj;
	}

	public void setObj(SerializableObject obj) {
		this.obj = obj;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


















	private SerializableObject obj;
	
	//浅复制
	public Object clone() throws CloneNotSupportedException{
		Prototype proto=(Prototype)super.clone();
		return proto;
	}
	
	/* 深复制 */ 
	public Object deepClone() throws IOException, ClassNotFoundException{
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		ObjectOutputStream oos=new ObjectOutputStream(bos);
		oos.writeObject(this);
		
		
		ByteArrayInputStream bis=new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream ois=new ObjectInputStream(bis);
		return ois.readObject();
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class SerializableObject implements Serializable{
	private static final long serialVersionUID=1l;
}














