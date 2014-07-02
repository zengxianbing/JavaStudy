package com.Algorithm.LinkedListSummary;

public class Demo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static class Node{
		int val;
		Node next;
		public Node(int val){
			this.val=val;
		}
	}
	
	public static void printList(Node head){
		while(head!=null){
			System.out.println(head.val+"  ");
			head=head.next;
		}
		System.out.println();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// 求单链表中结点的个数  
    // 注意检查链表是否为空。时间复杂度为O（n）  
	public static int getListLength(Node head){
		if(head==null){
			return 0;
		}
		
		int len=0;
		Node cur=head;
		while(cur!=null){
			len++;
			cur=cur.next;
		}
		return len;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
