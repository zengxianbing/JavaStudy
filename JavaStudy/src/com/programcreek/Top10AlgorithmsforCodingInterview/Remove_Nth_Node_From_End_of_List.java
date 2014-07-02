package com.programcreek.Top10AlgorithmsforCodingInterview;

public class Remove_Nth_Node_From_End_of_List {

	public ListNode removeNthFromEnd(ListNode head,int n){
		ListNode nodeN=head;
		ListNode nodeE=head;
		
		if(head.next==null)return null;
		
		for(int i=1;i<=n;i++){
			nodeE=nodeE.next;
		}
		
		if(nodeE==null){
			head=head.next;
			return head;
		}
		
		while(nodeE.next!=null){
			nodeE=nodeE.next;
			nodeN=nodeN.next;
		}
		
		nodeN.next=nodeN.next.next;
		return head;
	}

}
