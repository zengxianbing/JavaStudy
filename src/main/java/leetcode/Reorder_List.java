package leetcode;

public class Reorder_List {

	public static void reorderList(ListNode head){
		if(head!=null&&head.next!=null){
			ListNode slow=head;
			ListNode fast=head;
			
			while(fast!=null&&fast.next!=null&&fast.next.next!=null){
				System.out.println("pre"+slow.val+" "+fast.val);
				slow=slow.next;
				fast=fast.next.next;
				System.out.println("after "+slow.val+" "+fast.val);
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
		System.out.println("------");
		while(n!=null){
			System.out.println(n.val);
			n=n.next;
		}
		System.out.println();
	}
	
	

}
