package com.programcreek.simpleJAVA;

class Insect{
	private int size;
	private String color;
	public Insect(int size, String color) {
		super();
		this.size = size;
		this.color = color;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public void move(){
		System.out.println("Move");
	}
	
	public void attack(){
		move();
		System.out.println("Attack");
	}
	
}

class Bee extends Insect{

	public Bee(int size, String color) {
		super(size, color);
		// TODO Auto-generated constructor stub
	}
	public void move(){
		System.out.println("Fly");
	}
	
	public void attack(){
		move();
		super.attack();
	}
	
	
}

interface Attack{
	public void move();
	public void attack();
}

class AttackImpl implements Attack{

	private String move;
	private String attack;
	public AttackImpl(String move, String attack) {
		//super();
		this.move = move;
		this.attack = attack;
	}

	@Override
	public void move() {

		System.out.println(move);
	}

	@Override
	public void attack() {

		move();
		System.out.print(attack);
	}
	
}
public class InheritanceVSComposition {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Insect i=new Bee(1,"red");
		i.attack();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
