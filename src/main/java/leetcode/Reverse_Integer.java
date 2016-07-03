package leetcode;

public class Reverse_Integer {

	public int reverse(int x){
		boolean flag=false;
		
		if(x<0){
			x=0-x;
			flag=true;
		}
		
		int res=0;
		int p=x;
		
		while(p>0){
			int mod=p%10;
			p=p/10;
			res=res*10+mod;
		}
		
		if(flag){
			res=0-res;
		}
		
		return res;
	}
}
