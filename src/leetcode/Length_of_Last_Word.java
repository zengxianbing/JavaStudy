package leetcode;

public class Length_of_Last_Word {

	/*public int lengthOfLastWord(String s){
		char[] cs=s.toCharArray();
		int lastSpace=-1;
		int len=cs.length;
		for(;len>0&&cs[len-1]==' ';len--);
		for(int i=0;i<len;i++){
			if(cs[i]==' ')
				lastSpace=i;
		}
		return len-lastSpace-1;
		
	}*/
	
	
	
	
	
	

/*	public int lengthOfLastWord(String s){
		if(s==null||s.length()==0){
			return 0;
		}
		
		int len=s.length();
		int count=0;
		for(int i=len-1;i>-1;i--){
			if(s.charAt(i)!=' '){
				count++;
			}
			if(s.charAt(i)==' '&&count!=0){
				return count;
			}
		}
		return count;
	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int lengthOfLastWord(String s){
		int length=0;
		char[] chars=s.toCharArray();
		for(int i=s.length()-1;i>=0;i--){
			if(length==0){
				if(chars[i]==' '){
					continue;
				}else{
					length++;
				}
			}else{
				if(chars[i]==' '){
					break;
				}else{
					length++;
				}
			}
		}
		return length;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
