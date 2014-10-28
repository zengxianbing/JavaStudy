package com.zxb.Concurrency.ForkJoin;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

public class SortTask extends RecursiveAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final long[] array;
	final int start;
	final int end;
	private int THRESHOLD=100;
	
    public SortTask(long[] array){
    	this.array=array;
    	this.start=0;
    	this.end=array.length-1;
    }
	
    
    public SortTask(long[] array,int start,int end){
    	this.array=array;
    	this.start=start;
    	this.end=end;
    }
	
	
	
	
	
	
	@Override
	protected void compute() {

		if(end-start<THRESHOLD){
			
		}
	}
	private int partition(long[] array,int start,int end){
		long x=array[end];
		int i=start-1;
		for(int j=start;j<end;j++){
			if(array[j]<=x){
				i++;
				swap(array,i,j);
			}
		}
		 swap(array, i + 1, end);  
	        return i + 1; 
	}
	
	
	private void swap(long[] array,int i,int j){
		if(i!=j){
			long temp=array[i];
			array[i]=array[j];
			array[j]=temp;
			
			
			
		}
	}
	private void sequentiallySort(long[] array,int lo,int hi)
	{
		Arrays.sort(array,lo,hi+1);
	}
}
