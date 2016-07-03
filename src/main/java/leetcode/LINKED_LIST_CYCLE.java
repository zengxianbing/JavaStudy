package leetcode;

public class LINKED_LIST_CYCLE {

	
	public boolean hasCycle(ListNode head){
		ListNode  p=head;
		if(head==null){
			return false;
			
		}
		
		if(p.next==null){
			return false;
		}
		
		while(p.next!=null){
			if(head==p.next){
				return true;
			}
			p=p.next;
		}
		
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public boolean hasCycle1(ListNode head){
		ListNode fast=null;
		ListNode slow=null;
		
		if(head==null)
			return false;
		
		if(head.next==null)
			return false;
		
		while(fast!=null&&fast.next!=null){
			slow=slow.next;
			
			fast=fast.next.next;
			
			if(slow==fast)
				return true;
		}
		
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
