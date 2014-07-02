package com.programcreek.Top10AlgorithmsforCodingInterview;

import java.util.Arrays;

public class Multiply_Strings {

	/*public static String multiply(String num1, String num2) {
		String n1 = new StringBuilder(num1).reverse().toString();
		String n2 = new StringBuilder(num2).reverse().toString();

		int[] d = new int[n1.length() + n2.length()];
		for (int i = 0; i < n1.length(); i++) {
			for (int j = 0; j < n2.length(); j++) {
				d[i + j] += (n1.charAt(i) - '0') * (n2.charAt(j) - '0');
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < d.length; i++) {
			int digit = d[i] % 10;
			int carry = d[i] / 10;
			if (i + 1 < d.length) {
				d[i + 1] += carry;
			}
			sb.insert(0, digit);
		}

		while (sb.charAt(0) == '0' && sb.length() > 1) {
			sb.deleteCharAt(0);
		}
		return sb.toString();

	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String multiply(String num1,String num2){
		char[] cs1=num1.toCharArray();
		char[] cs2=num2.toCharArray();
		
		reverse(cs1);
		reverse(cs2);
		char[] cs=mul(cs1,cs2);
		reverse(cs);
		
		int n=cs.length;
		int start=0;
		for(;start<n-1&&cs[start]=='0';start++)
			;
		return new String(cs,start,n-start);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private char[] mul(char[] cs1,char[] cs2){
		int n1=cs1.length;
		int n2=cs2.length;
		int n=n1+n2;
		char[] cs=new char[n];
		Arrays.fill(cs, '0');
		for(int i=0;i<n1;i++){
			for(int j=0;j<n2;j++){
				int val=(cs1[i]-'0')*(cs2[j]-'0')+cs[i+j]-'0';
				cs[i+j]=(char)(val%10+'0');
				if(i+j+1<n)
					cs[i+j+1]+=val/10;
			}
		}
		return cs;
	}
			
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private void reverse(char[] cs){
		int i=0;
		int j=cs.length-1;
		while(i<j){
			swap(cs,i++,j--);
		}
	}
	
	private void swap(char[] cs,int i,int j){
		char tmp=cs[i];
		cs[i]=cs[j];
		cs[j]=tmp;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
