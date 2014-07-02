package com.programcreek.Top10AlgorithmsforCodingInterview;

public class Reverse_Linked_List_II {

	public ListNode reverseBetween(ListNode head,int m,int n){
		ListNode mNode=head;
		ListNode nNode=head;
		
		ListNode mPreNode=new ListNode(0);
		mPreNode.next=head;
		
		for(int i=0;i<n-m;i++)
			nNode=nNode.next;
		
		for(int i=0;i<m-1;i++){
			mPreNode=mNode;
			mNode=mNode.next;
			nNode=nNode.next;
		}
		
		boolean formHead=false;
		if(mNode==head) formHead=true;
		
		while(mNode!=nNode){
			ListNode temp=nNode.next;
			nNode.next=mNode;
			mPreNode.next=mNode.next;
			mNode.next=temp;
			mNode=mPreNode.next;
		}
		if(formHead==true)
			return nNode;
		return head;
				
	}
}
