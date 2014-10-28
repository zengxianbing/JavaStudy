package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Interval{
	int start;
	int end;
	Interval(){
		start=0;
		end=0;
	}
	
	Interval(int s,int e){
		start=s;
		end=e;
	}
}
public class MERGE_INT_ERVALS {

	/**
	 * 
	 * @param intervals
	 * @return
	 */
	public ArrayList<Interval> merge(ArrayList<Interval> intervals){
		if(intervals==null||intervals.size()<=1){
			return intervals;
		}
		Collections.sort(intervals, new IntervalComparator());
		
		ArrayList<Interval> result=new ArrayList<Interval>();
		
		Interval prev=intervals.get(0);
		
		for(int i=0;i<intervals.size();i++){
			
			Interval curr=intervals.get(i);
			if(prev.end>=curr.start){
				Interval merged=new Interval(prev.start,
						Math.max(prev.end, curr.end));
				
				prev=merged;
			}else{
				result.add(prev);
				prev=curr;
			}
		}
		result.add(prev);
		return result;
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
	public ArrayList<Interval> insert(ArrayList<Interval> intervals,Interval newInterval){
		
		ArrayList<Interval> result=new ArrayList<Interval>();
		
		for(Interval interval:intervals){
			if(interval.end<newInterval.start){
				result.add(interval);
			}else if(interval.start>newInterval.end){
				result.add(newInterval);
				newInterval=interval;
			}else if(interval.end>=newInterval.start||
					interval.start<=newInterval.end){
				newInterval=new Interval(Math.min(interval.start, newInterval.start),
						Math.max(newInterval.end, interval.end));
			}
		}
		
		result.add(newInterval);
		return result;
	}
	
	
	public int[] twoSum(int[] numbers,int target){
		int[] ret=new int[2];
		for(int i=0;i<numbers.length;i++){
			if(numbers[i]<=target){
				for(int j=i+1;j<numbers.length;j++){
					if(numbers[i]+numbers[j]==target){
						ret[0]=i+1;
						ret[1]=j+1;
					}
				}
			}
		}
		
		return ret;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}





class IntervalComparator implements Comparator<Interval>{

	@Override
	public int compare(Interval i1, Interval i2) {
		return i1.start-i2.start;
	}
	
}



















