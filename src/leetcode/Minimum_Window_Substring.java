package leetcode;

import java.util.HashMap;

public class Minimum_Window_Substring {
	public String minWindow(String S, String T) {
	    if(S == null || T == null || S.length()==0 || T.length()==0)
	        return "";
	    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	    for(int i=0;i<T.length();i++)
	    {
	        if(map.containsKey(T.charAt(i)))
	        {
	            map.put(T.charAt(i), map.get(T.charAt(i))+1);
	        }
	        else
	            map.put(T.charAt(i), 1);
	    }
	    int count = 0;
	    int pre = 0;
	    String res = "";
	    int minLen = S.length()+1;
	    for(int i=0;i<S.length();i++)
	    {
	        if(map.containsKey(S.charAt(i)))
	        {
	            map.put(S.charAt(i),map.get(S.charAt(i))-1);
	            if(map.get(S.charAt(i))>=0)
	                count++;
	            while(count == T.length())
	            {
	                if(map.containsKey(S.charAt(pre)))
	                {
	                    map.put(S.charAt(pre),map.get(S.charAt(pre))+1);
	                    if(map.get(S.charAt(pre))>0)
	                    {
	                        if(minLen>i-pre+1)
	                        {
	                            res = S.substring(pre,i+1);
	                            minLen = i-pre+1;
	                        }
	                        count--;
	                    }
	                }
	                pre++;
	            }
	        }
	    }
	    return res;
	}
}
