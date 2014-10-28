package leetcode;


public class Add_Two_Numbers {

	
	public ListNode addTwoNumbers(ListNode l1,ListNode l2){
		
		 ListNode p1 = l1;
	        ListNode p2 = l2;
	 
	        ListNode newHead = new ListNode(0);
	        ListNode p3 = newHead;
	 
	        int val;//store sum
	 
	        boolean flag = false;//flag if greater than 10
	 
	        while(p1 != null || p2 != null){
	            //both p1 and p2 have value
	            if(p1 != null && p2 != null){
	 
	                if(flag){
	                    val = p1.val + p2.val + 1;
	                }else{
	                    val = p1.val + p2.val;
	                }
	 
	                //if sum >= 10
	                if(val >= 10 ){
	                    flag = true;
	 
	                //if sum < 10
	                }else{
	                    flag = false;
	                }
	 
	                p3.next = new ListNode(val%10);
	                p1 = p1.next;
	                p2 = p2.next;
	            //p1 is null, because p2 is longer                
	            }else if(p2 != null){
	 
	                if(flag){
	                    val = p2.val + 1;
	                    if(val >= 10){
	                        flag = true;
	                    }else{
	                        flag = false;
	                    }
	                }else{
	                    val = p2.val;
	                    flag = false;
	                }
	 
	                p3.next = new ListNode(val%10); 
	                p2 = p2.next;
	 
	            ////p2 is null, because p1 is longer  
	            }else if(p1 != null){
	 
	                if(flag){
	                    val = p1.val + 1;
	                    if(val >= 10){
	                        flag = true;
	                    }else{
	                        flag = false;
	                    }
	                }else{
	                    val = p1.val;
	                    flag = false;
	                }
	 
	                p3.next = new ListNode(val%10); 
	                p1 = p1.next;
	            }
	 
	            p3 = p3.next;
	        }
	 
	        //handle situation that same length final sum >=10
	        if(p1 == null && p2 == null && flag){
	            p3.next = new ListNode(1);
	        }
	 
	        return newHead.next;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public ListNode addTwoNumbers1(ListNode l1,ListNode l2){
		int carry=0;
		
		ListNode newHead=new ListNode(0);
		
		ListNode p1=l1,p2=l2,p3=newHead;
		while(p1!=null||p2!=null){
			if(p1!=null){
				carry+=p1.val;
				p1=p1.next;
			}
			
			if(p2!=null){
				carry+=p2.val;
				p2=p2.next;
			}
			
			p3.next=new ListNode(carry%10);
			p3=p3.next;
			carry/=10;
		}
		
		if(carry==1){
			p3.next=new ListNode(1);
		}
		return newHead.next;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
