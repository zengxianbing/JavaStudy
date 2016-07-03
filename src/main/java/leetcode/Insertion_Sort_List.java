package leetcode;

public class Insertion_Sort_List {

	public static ListNode insertionSortList(ListNode head){
	
		if(head==null||head.next==null)
			return head;
		
		ListNode newHead=new ListNode(head.val);
		ListNode pointer=head.next;
		
		while(pointer!=null){
			ListNode innerPointer=newHead;
			ListNode next=pointer.next;
			
			if(pointer.val<=newHead.val){
				ListNode oldHead=newHead;
				newHead=pointer;
				newHead.next=oldHead;
				
			}else{
				while(innerPointer.next!=null){
					if(pointer.val>innerPointer.val&&
							pointer.val<=innerPointer.val){
						ListNode oldNext=innerPointer.next;
						innerPointer.next=pointer;
						pointer.next=oldNext;
					}
					
					innerPointer=innerPointer.next;
				}
				
				if(innerPointer.next==null&&
						pointer.val>innerPointer.val){
					innerPointer.next=pointer;
					pointer.next=null;
					
				}
			}
			pointer=next;
		}
		return pointer;
		
	}
	
	public static void printList(ListNode x){
		if(x!=null){
			System.out.println(x.val+" ");
			while(x.next!=null){
				System.out.println(x.next.val+" ");
				x=x.next;
			}
			System.out.println();
		}
	}
}
