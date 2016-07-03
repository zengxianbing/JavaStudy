package leetcode;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;

class UndirectedGraphNode {
	int label;
	ArrayList<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
}

public class Clone_Graph {

	/*public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		   if(node == null)
	            return null;
	 
	        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
	        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = 
	                                   new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
	 
	        UndirectedGraphNode newHead = new UndirectedGraphNode(node.label);
	 
	        queue.add(node);
	        map.put(node, newHead);
	 
	        while(!queue.isEmpty()){
	            UndirectedGraphNode curr = queue.pop();
	            ArrayList<UndirectedGraphNode> currNeighbors = curr.neighbors; 
	 
	            for(UndirectedGraphNode aNeighbor: currNeighbors){
	                if(!map.containsKey(aNeighbor)){
	                    UndirectedGraphNode copy = new UndirectedGraphNode(aNeighbor.label);
	                    map.put(aNeighbor,copy);
	                    map.get(curr).neighbors.add(copy);
	                    queue.add(aNeighbor);
	                }else{
	                    map.get(curr).neighbors.add(map.get(aNeighbor));
	                }
	            }
	 
	        }
	        return newHead;
	}*/
	
	
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null){
        	return null;
        }
        
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();		// BFS用的queue
        // Hashtable<node, clonedNode> 放原始node和其复制品
        Hashtable<UndirectedGraphNode, UndirectedGraphNode> ht = new Hashtable<UndirectedGraphNode, UndirectedGraphNode>();	// 去重用的ht
        UndirectedGraphNode retClone = new UndirectedGraphNode(node.label);	// 根节点的复制
    	ht.put(node, retClone);		// 把根节点和其复制品放入ht
        queue.add(node);		//添加入队列
        
        while(!queue.isEmpty()){
        	UndirectedGraphNode cur = queue.remove();		// 当前处理对象
        	UndirectedGraphNode curClone = ht.get(cur);	// 当前处理对象的复制品，必定在ht里，因为在前面的neighbor里已经被创建
        	
        	ArrayList<UndirectedGraphNode> neighbors = cur.neighbors;	// 得到当前原始对象的所有neighbor
        	for(int i=0; i<neighbors.size(); i++){		// 对每一个neighbor进行判断，因为有的neighbor已经被复制，有的没有
        		UndirectedGraphNode neighbor = neighbors.get(i);
        		if(ht.containsKey(neighbor)){		// 之前已经被复制过的neighbor
        			UndirectedGraphNode neighborClone = ht.get(neighbor);	// 就直接从ht里取出neighborClone
        			curClone.neighbors.add(neighborClone);		// 给curClone添加复制的neighbor
        		}else{	// 如果该neighbor没有被复制过，则新建neighborClone
        			UndirectedGraphNode neighborClone = new UndirectedGraphNode(neighbor.label);
        			curClone.neighbors.add(neighborClone);
        			ht.put(neighbor, neighborClone);		// 存储到ht里
        			queue.add(neighbor);		// 并且添加到队列里为了将来的遍历
        		}
        	}
        }
        
        return retClone;
    }
}
