package com.performanceoptimize;

public class SplitTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	
	
	
	public void split(String orgStr){
		String tmp=orgStr;
		for (int i = 0; i <1000; i++) {
			while(true){
				String splitStr=null;
				int j=tmp.indexOf(';');
				if(j<0)break;
				splitStr=tmp.substring(0,j);
				tmp=tmp.substring(j+1);
			}
			tmp=orgStr;
		}
	}
	
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
