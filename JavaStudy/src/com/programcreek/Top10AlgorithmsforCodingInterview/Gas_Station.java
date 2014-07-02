package com.programcreek.Top10AlgorithmsforCodingInterview;

public class Gas_Station {

	
	public int canCompleteCircuit(int[] gas,int[] cost){
		int N=gas.length,startIndex=-1;
		
		int sum=0,total=0;
		for(int i=0;i<N;i++){
			sum+=(gas[i]-cost[i]);
			total+=(gas[i]-cost[i]);
			if(sum<0){
				startIndex=i;
				sum=0;
			}
		}
		return total>=0?startIndex+1:-1;
	}
}
