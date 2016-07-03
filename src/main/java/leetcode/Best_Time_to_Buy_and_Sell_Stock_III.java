package leetcode;

public class Best_Time_to_Buy_and_Sell_Stock_III {

	
	
	public static int maxProfit(int[] prices){
		if(prices.length==0)
			return 0;
		
		int max=0;
		int[] left=new int[prices.length];
		int[] right=new int[prices.length];
		
		process(prices,left,right);
		
		for(int i=0;i<prices.length;i++){
			max=Math.max(max, left[i]+right[i]);
			
			
			
		}
		return max;
	}
	
	
	
	
	
	
	
	
	
	
	
	public static void process(int[] prices,int[] left,
			int[] right){
		left[0]=0;
		int min=prices[0];
		
		for(int i=1;i<left.length;i++){
			left[i]=left[i-1]>prices[i]-min?
				left[i-1]:prices[i]-min;
		    min=prices[i]<min?prices[i]:min;
		}
		
		right[right.length-1]=0;
		int max=prices[right.length]-1;
		
		for(int i=right.length-2;i>=0;i--){
			right[i]=right[i+1]>max-prices[i+1]?
					right[i+1]:max-prices[i];
					
		  max=prices[i]>max?prices[i]:max;
		}
	}
}
