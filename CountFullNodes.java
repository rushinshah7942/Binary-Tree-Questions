/*
A FULL node in a binary tree is a node that has exactly two non-null children. Write a RECURSIVE function that returns the number of full nodes in a binary tree.
*/

public int FullNodes(TreeNode root){
    
    if(root == null) //if tree is empty
        return 0;
		
    if(root.left == null && root.right == null) //leaf nodes
        return 0;
		
    if(root.left != null && root.right != null) // Full Nodes
        return 1 + FullNodes(root.left) + FullNodes(root.right);

    if(root.left==null || root.right == null) //Nodes with only left or right
        return FullNodes(root.left) + FullNodes(root.right);
}