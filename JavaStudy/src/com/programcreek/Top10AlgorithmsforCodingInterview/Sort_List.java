package com.programcreek.Top10AlgorithmsforCodingInterview;

public class Sort_List {

	
	public ListNode sortList(ListNode head){
		if(head==null||head.next==null){
			return head;
		}
		
		ListNode fast=head;
		ListNode slow=head;
		
		while(fast.next!=null){
			fast=fast.next.next;
			if(fast==null){
				break;
			}
			slow=slow.next;
		}
		
		ListNode right=slow.next;
		slow.next=null;
		
		ListNode left=sortList(head);
		right=sortList(right);
		return  mergeTwoLists(left,right);
		
	}
	
	
	
	
	
	
	
	
	
	public ListNode mergeTwoLists(ListNode l1,ListNode l2){
		if(l1==null){
			return l2;
		}
		
		if(l2==null){
			return l1;
		}
		
		
		ListNode node=null;
		ListNode head=null;
		
		while(l1!=null&&l2!=null){
			if(l1.val<=l2.val){
				if(node==null){
					node=l1;
					head=node;
				}else{
					node.next=l1;
					node=node.next;
				}
				
				l1=l1.next;
			}else{
				if(node==null){
					node=l2;
					head=node;
				}else{
					node.next=l2;
					node=node.next;
				}
				
				l2=l2.next;
			}
		}
		
		if(l1!=null){
			node.next=l1;
		}else if(l2!=null){
			node.next=l2;
		}
		return head;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
