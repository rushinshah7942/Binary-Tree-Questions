/*
Given a root of Binary Search Tree with unique value for each node.  Remove the node with given value. If there is no such a node with given value in the binary search tree, do nothing. You should keep the tree still a binary search tree after removal.
*/

// Reference : https://www.youtube.com/watch?v=gcULXE7ViZw

public class Solution{
	public TreeNode removeNode(TreeNode root, int value){
		if(root == null)
			return root;
	
		if(value < root.val){
			root.left = removeNode(root.left,value);
		}
		else if(value > root.val){
			root.right = removeNode(root.right, value);
		}
		else{
			if(root.left == null){ // no left sub-tree
				return root.right;
			} 		
			else if{ // no right sub-tree
				return root.left;	
			}
			// find minimum node in right subtree
			TreeNode tempNode = findMin(root.right);
			int temp = root.val;
			root.val = tempNode.val;
			tempNode.val = temp;
			root.right = removeNode(root.right,tempNode.value); // remove that tempnode
		}
		return root;
	}
	public TreeNode findMin(TreeNode root){
		while(root.left != null){
			root = root.left;
		}
		return root;
	}
}