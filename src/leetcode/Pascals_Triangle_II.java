package leetcode;

import java.util.ArrayList;

public class Pascals_Triangle_II {

	
	public ArrayList<Integer> getRow(int rowIndex){
		ArrayList<Integer> rs=new ArrayList<Integer>();
		
		if(rowIndex==0){
			rs.add(1);
			return rs;
			
		}
		
		rs.add(1);
		for(int i=1;i<=rowIndex;i++){
			rs.add(0,1);
			for(int j=1;j<=i-1;j++){
				rs.set(j, rs.get(j)+rs.get(j+1));
			}
		}
		return rs;
	}
}
