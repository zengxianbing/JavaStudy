package leetcode;

public class Partition_List {

	public ListNode partition(ListNode head,int x){
		if(head==null) return null;
		
		ListNode fakeHead1=new ListNode(0);
		ListNode fakeHead2=new ListNode(0);
		
		fakeHead1.next=head;
		
		ListNode p=head;
		ListNode prev=fakeHead1;
		ListNode p2=fakeHead2;
		
		while(p!=null){
			if(p.val<x){
				p=p.next;
				prev=prev.next;
			}else{
				p2.next=p;
				prev.next=p.next;
				
				
				p=prev.next;
				p2=p2.next;
			}
		}
		
		p2.next=null;
		prev.next=fakeHead2.next;
		return fakeHead1.next;
	}
}
