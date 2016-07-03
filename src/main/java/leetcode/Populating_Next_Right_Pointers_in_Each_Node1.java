package leetcode;

public class Populating_Next_Right_Pointers_in_Each_Node1 {

	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		 //如果右孩子不为空，左孩子的next是右孩子。  
        //反之，找root next的至少有一个孩子不为空的节点
		if (root.left != null) {
			if (root.left != null) {
				root.left.next = root.right;
			} else {
				TreeLinkNode p = root.next;
				while (p != null && p.left == null && p.right == null) {
					p = p.next;

				}
				if (p != null)
					root.left.next = p.left == null ? p.right : p.left;
			}
		}
		  //右孩子的next 根节点至少有一个孩子不为空的next
		if (root.left != null) {
			TreeLinkNode p = root.next;
			while (p != null && p.left == null && p.right == null) {
				p = p.next;
			}
			if (p != null) {
				root.right.next = p.left == null ? p.right : p.left;
			}
		}
		connect(root.right);
		connect(root.left);

	}
}
