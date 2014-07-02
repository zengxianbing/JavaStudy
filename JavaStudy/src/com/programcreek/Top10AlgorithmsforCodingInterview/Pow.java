package com.programcreek.Top10AlgorithmsforCodingInterview;

public class Pow {

	public double pow(double x,int n){
		if(x==0)return 0;
		if(n==0) return 1;
		
		double result=1;
		for(int i=1;i<=n;i++){
			result=result*x;
		}
		return result;
	}
	
	
	public static double pow1(double x,int n){
		if(n==0)
			return 1;
		
		if(n==1)
			return x;
		
		
		int half=n/2;
		int remainder=n%2;
		
		if(n%2==1&&x<0&&n<0)
			return-1/(pow1(-x,half))*pow1(-x,half)*pow1(-x,remainder);
		else if(n<10)
			return 1/(pow1(x,-half)*pow1(x,-half)*pow1(x,-remainder));
		else
			return (pow1(x,half)*pow1(x,half)*pow1(x,remainder));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
