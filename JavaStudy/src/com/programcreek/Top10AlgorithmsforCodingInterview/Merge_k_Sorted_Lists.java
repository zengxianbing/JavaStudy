package com.programcreek.Top10AlgorithmsforCodingInterview;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Merge_k_Sorted_Lists {

	public ListNode mergeKLists(ArrayList<ListNode> lists){
		if(lists.size()==0)
			return null;
		
		PriorityQueue<ListNode> q=new PriorityQueue<ListNode>(lists.size(),
				new Comparator<ListNode>(){

					@Override
					public int compare(ListNode o1, ListNode o2) {

					  if(o1.val>o2.val)
						  return 1;
					  else if(o1.val==o2.val)
						  return 0;
					  else 
						  return -1;
					}
			
		});
		
		
		for(ListNode list:lists){
			if(list!=null)
				q.add(list);
		}
		
		ListNode head=new ListNode(0);
		ListNode prev=head;
		
		while(q.size()>0){
			ListNode temp=q.poll();
			
			prev.next=temp;
			
			if(temp.next!=null)
				q.add(temp.next);
			
			prev=prev.next;
		}
		
		return head.next;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
