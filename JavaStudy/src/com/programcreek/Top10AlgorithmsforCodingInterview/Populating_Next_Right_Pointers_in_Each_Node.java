package com.programcreek.Top10AlgorithmsforCodingInterview;

public class Populating_Next_Right_Pointers_in_Each_Node {

	
	public static void connect(TreeLinkNode root){
		  // 空节点就直接返回  
        if (root == null){  
            return;  
        }  
           
        // 找到与root同一行的next node  
        TreeLinkNode rootNext = root.next;  
        TreeLinkNode next = null;       // 下一个被连接的对象  
           
        // rootNext如果是null说明已经处理完这一层的所有node  
        // next不等于null说明找到了找到最左边的下一个被连接的对象  
        while (rootNext != null && next == null)  
        {  
            if (rootNext.left != null){ // 优先找左边  
                next = rootNext.left;  
            } else{  
                next = rootNext.right;  
            }  
            rootNext = rootNext.next;  
        }  
    
        if (root.left != null)  
        {  
            if (root.right != null){    //  内部相连  
                root.left.next = root.right;  
            }else{                      // 跨树相连  
                root.left.next = next;  
            }  
        }  
        if (root.right != null){        // 跨树相连  
            root.right.next = next;  
        }  
           
        connect(root.right);        // 要先让右边都先连起来  
        connect(root.left);  
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
