package com.programcreek.simpleJAVA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class HDIV implements Comparable<HDIV>{

	private  int size;
	
	private String brand;
	
	public HDIV(int size, String brand) {
		super();
		this.size = size;
		this.brand = brand;
	}

	
	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	@Override
	public int compareTo(HDIV tv) {

		if(this.getSize()>tv.getSize())
			return 1;
		else if(this.getSize()<tv.getSize())
            return -1;
		else
			return 0;
	}
	
}


class SizeComparator implements Comparator<HDIV>{

	@Override
	public int compare(HDIV tv1, HDIV tv2) {
        int tv1Size=tv1.getSize();
        int tv2Size=tv2.getSize();
        if(tv1Size>tv2Size){
        	return 1;
        }else if(tv1Size<tv2Size){
        	return -1;
        }else{
        	return 0;
        }
	}
	
}
public class ComparableTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

//		HDIV tv1=new HDIV(55,"Samsung");
//		HDIV tv2=new HDIV(60,"Sony");
//		if(tv1.compareTo(tv2)>0){
//			System.out.println(tv1.getBrand()+"is better");
//		}else{
//		System.out.println(tv2.getBrand()+"is better");
//		}
//		}
	HDIV tv1=new HDIV(55,"Samsung");
	HDIV tv2=new HDIV(60,"Sony");
	HDIV tv3=new HDIV(42,"Panasonic");

	ArrayList<HDIV> a1=new ArrayList<HDIV>();
	a1.add(tv1);
	a1.add(tv2);
	a1.add(tv3);
	Collections.sort(a1,new SizeComparator());
	for(HDIV a:a1){
		System.out.println(a.getBrand());
	}
	
	
	ArrayList<Integer> a2=new ArrayList<Integer>();
	a2.add(3);
	a2.add(1);
	a2.add(2);
	
	
	System.out.println(a2);
	Collections.sort(a2);
	System.out.println(a2);
	
	
	Comparator<Integer> comparator=Collections.reverseOrder();
	Collections.sort(a2,comparator);
	System.out.println(a2);
	
}

}
