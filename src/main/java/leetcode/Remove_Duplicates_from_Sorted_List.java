package leetcode;

public class Remove_Duplicates_from_Sorted_List {

	public ListNode deleteDuplicates(ListNode head){
		if(head==null||head.next==null)
			return head;
		
		ListNode prev=head;
		ListNode p=head.next;
		
		while(p!=null){
			if(p.val==prev.val){
				prev.next=p.next;
				p=p.next;
			}else{
				prev=p;
				p=p.next;
			}
		}
		return head;
	}
	
	
	public ListNode deleteDuplicates1(ListNode head){
		if(head==null||head.next==null)
			return head;
		ListNode p=head;
		
		while(p!=null&&p.next!=null){
			if(p.val==p.next.val){
				p.next=p.next.next;
			}else{
				p=p.next;
			}
			
		}
		return head;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
