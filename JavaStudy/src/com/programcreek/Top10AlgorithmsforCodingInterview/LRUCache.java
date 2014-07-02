package com.programcreek.Top10AlgorithmsforCodingInterview;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

/*	private HashMap<Integer, DoubleLinkedListNode> map = new HashMap<Integer, DoubleLinkedListNode>();

	private DoubleLinkedListNode head;
	private DoubleLinkedListNode end;
	private int capacity;
	private int len;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		len = 0;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			DoubleLinkedListNode latest = map.get(key);
			removeNode(latest);
			setHead(latest);
			return latest.val;
		} else {
			return -1;
		}
	}

	public void removeNode(DoubleLinkedListNode node) {
		DoubleLinkedListNode cur = head;
		DoubleLinkedListNode pre = cur.pre;
		DoubleLinkedListNode post = cur.next;

		if (pre != null) {
			pre.next = post;
		} else {
			head = post;
		}

		if (post != null) {
			post.pre = pre;
		} else {
			end = pre;
		}

	}

	public void setHead(DoubleLinkedListNode node) {
		node.next = head;
		node.pre = null;
		if (head != null) {
			head.pre = node;
		}

		head = node;
		if (end == null) {
			end = node;
		}
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			DoubleLinkedListNode oldNode = map.get(key);
			oldNode.val = value;
			removeNode(oldNode);
			setHead(oldNode);
		} else {
			DoubleLinkedListNode newNode = new DoubleLinkedListNode(key, value);

			if (len < capacity) {
				setHead(newNode);
				map.put(key, newNode);
				len++;
			} else {
				map.remove(end.key);
				end = end.pre;
				if (end != null) {
					end.next = null;
				}

				setHead(newNode);
				map.put(key, newNode);
			}
		}
	}*/

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private int capacity;
	private Map<Integer,Entry> nodes;
	
	private int currentSize;
	private Entry first;
	
	private Entry last;
	
	public LRUCache(int capacity){
		this.capacity=capacity;
		currentSize=0;
		nodes=new HashMap<Integer,Entry>();
	}
	
	
	
	public int get(int key){
		Entry node=nodes.get(key);
		if(node!=null){
			moveToHead(node);
			return node.value;
		}else{
			return -1;
		}
	}
	
	
	
	
	
	
	
	public void set(int key,int value){
		Entry node=nodes.get(key);
		if(node==null){
			if(currentSize>=capacity){
				nodes.remove(last.key);
				removeLast();
			}else{
				currentSize++;
			}
			node=new Entry();
		}
		
		if(currentSize==1){
			first=node;
			last=node;
		}
		
		node.key=key;
		node.value=value;
		moveToHead(node);
		nodes.put(key, node);
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	private void moveToHead(Entry node){
		if(node==first)
			return;
		
		if(node.pre!=null){
			node.pre.next=node.next;
		}
		
		if(node.next!=null){
			node.next.pre=node.pre;
		}
		
		if(last==node){
			last=node.pre;
		}
		
		if(first!=null){
			node.next=first;
			first.pre=node;
		}
		
		first=node;
		node.pre=null;
	}
	
	
	private void removeLast(){
		if(last!=null){
			if(last.pre!=null){
				last.pre.next=null;
			}else{
				first=null;
			}
			last=last.pre;
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


class Entry{
	Entry pre;
	Entry next;
	int key;
	int value;
}
class DoubleLinkedListNode {
	public int val;
	public int key;
	public DoubleLinkedListNode pre;
	public DoubleLinkedListNode next;

	public DoubleLinkedListNode(int key, int value) {
		this.val = value;
		this.key = key;
	}

}