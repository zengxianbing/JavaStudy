package leetcode;

import java.util.LinkedList;

public class Symmetric_Tree {

	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return cmp(root.left, root.right);

	}

	public boolean cmp(TreeNode l, TreeNode r) {
		boolean f1 = false, f2 = false;
		if (l == null && r == null) {
			return true;
		}

		if ((l != null && r == null) || (l == null && r != null)) {
			return false;
		}

		if (l.val != r.val) {
			return false;
		}

		f1 = cmp(l.left, r.right);
		f2 = cmp(l.right, r.left);

		if (f1 && f2) {
			return true;
		}

		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	public boolean isSymmetric1(TreeNode root){
		if(root==null){
			return true;
		}
		
		LinkedList<TreeNode> l=new LinkedList<TreeNode>(),
				r=new LinkedList<TreeNode>();
		
		l.add(root.left);
		r.add(root.right);
		while(!l.isEmpty()&&!r.isEmpty()){
			TreeNode t1=l.poll(),t2=r.poll();
			if((t1==null&&t2!=null)||
					(t1!=null&&t2==null)){
				return false;
			}
			if(t1!=null){
				if(t1.val!=t2.val){
					return false;
				}
				
				l.add(t1.left);
				l.add(t1.right);
				r.add(t2.right);
				r.add(t2.right);
			}
		}
		return false;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
