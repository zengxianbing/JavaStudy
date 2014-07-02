package com.programcreek.Top10AlgorithmsforCodingInterview;

public class swap_nodes_in_pairs {

	public ListNode swapPairs(ListNode head){
		if(head==null||head.next==null)
			return head;
		
		ListNode fake=new ListNode(0);
		fake.next=head;
		
		ListNode pre=fake;
		ListNode cur=head;
		
		while(cur!=null&&cur.next!=null){
			pre.next=cur.next;
			cur.next=cur.next.next;
			pre.next.next=cur;
			
			pre=cur;
			cur=pre.next;
		}
		return fake.next;
	}
}
