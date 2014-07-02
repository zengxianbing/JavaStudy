package com.programcreek.Top10AlgorithmsforCodingInterview;

public class Count_and_Say {

/*	
	public static String countAndSay(int n){
		if(n==1){
			return "1";
			
			
		}
		
		String s="1";
		StringBuffer ret=new StringBuffer();
		int cnt=0;
		int round=0;
		int i;
		while(++round<n){
			cnt=1;
			ret.setLength(0);
			for(i=1;i<s.length();i++){
				if(s.charAt(i)==s.charAt(i-1)){
					cnt++;
				}else{
					ret.append(cnt).append(s.charAt(i-1));
					cnt=1;
				}
			}
			ret.append(cnt).append(s.charAt(i-1));
			s=ret.toString();
		}
		return ret.toString();
	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String countAndSay(int n){
		char[] ori=new char[]{'1'};
		StringBuffer sb=null;
		for(int i=1;i<n;i++){
			sb=new StringBuffer();
			int len=ori.length;
			int begin=0;
			for(int j=1;j<=len;j++){
				if(j==len||ori[j]!=ori[begin]){
					sb.append(""+(j-begin));
					sb.append(ori[begin]);
					begin=j;
				}
				
			}
			ori=sb.toString().toCharArray();
			
		}
		return new String(ori);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
