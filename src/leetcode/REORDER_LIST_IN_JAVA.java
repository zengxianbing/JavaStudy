package leetcode;

public class REORDER_LIST_IN_JAVA {

	
	
	public static void main ( String [ ] args ) {
		ListNode n1 = new ListNode ( 1 ) ;
		ListNode n2 = new ListNode ( 2 ) ;
		ListNode n3 = new ListNode ( 3 ) ;
		ListNode n4 = new ListNode ( 4 ) ;
		
		n1 . next = n2 ;
		n2 . next = n3 ;
		n3 . next = n4 ;
		printList ( n1 ) ;
		reorderList( n1 ) ;
		printList( n1 ) ;
		}
	
	
	
	
	
	public static void reorderList(ListNode head){
		if(head!=null&&head.next!=null){
			ListNode slow=head;
			ListNode fast=head;
			
//			 us e a f a s t and s l ow p o i n t e r t o b r e a k t h e l i n k t o two
//			p a r t s .
			
			while(fast!=null&&fast.next!=null&&fast.next.next!=null){
              System.out.println("pre_"+slow.val
            		  +"-"+fast.val);
              slow=slow.next;
              fast=fast.next.next;
              System.out.println("after_"+slow.val+
            		  "_"+fast.val);
		}
			
	    ListNode second=slow.next;
	    slow.next=null;
	    
	    second=reverseOrder(second);
		ListNode p1=head;
		ListNode p2=second;
		
		
		while(p2!=null){
		
			ListNode temp1=p1.next;
			ListNode temp2=p2.next;
			p1.next=p2;
			p2.next=temp1;
			p1=temp1;
			p2=temp2;
		}
		}
	    
	}
	
	public static ListNode reverseOrder(ListNode head){
		
		if(head==null||head.next==null){
			return head;
		}
		
		ListNode pre=head;
		ListNode curr=head.next;
		
		while(curr!=null){
			
          ListNode temp=curr.next;
          curr.next=pre;
          pre=curr;
          curr=temp;
		}
		head.next=null;
		return pre;
	}
	
	
	public static void printList(ListNode n){
		System.out.println("_________");
		while(n!=null){
			System.out.println(n.val);
			n=n.next;
		}
		System.out.println();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
