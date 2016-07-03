package com.zxb.baobaotao.reflect;
public class Car {
	private String brand;
	private String color;
	private int maxSpeed;
    
     //��Ĭ�Ϲ��캯��
	public Car(){}
     
     //�ڴ�ι��캯��
	public Car(String brand,String color,int maxSpeed){ 
		this.brand = brand;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}

     //��δ��εķ���
	public void introduce() { 
       System.out.println("brand:"+brand+";color:"+color+";maxSpeed:" +maxSpeed);
	}
     //ʡ�Բ����getter/Setter����
    
}