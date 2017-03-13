/*
Given a binary tree, find the maximum path sum. The path may start and end at any node in the tree. For example, given the below binary tree

       1
      / \
     2   3
the result is 6.
*/

/*
Analysis

1) Recursively solve this problem
2) Get largest left sum and right sum
2) Compare to the stored maximum
*/

public int maxPathSum(TreeNode root) {
	int max[] = new int[1]; 
	max[0] = Integer.MIN_VALUE;
	calculateSum(root, max);
	return max[0];
}
 
public int calculateSum(TreeNode root, int[] max) 
{
	if (root == null)
		return 0;
 
	int left = calculateSum(root.left, max);
	int right = calculateSum(root.right, max);
 
	int current = Math.max(root.val, Math.max( root.val + left ,  root.val + right ) ); // left or right 
 
	max[0] = Math.max( max[0],  Math.max( current,  left + root.val + right) ); // including root as well 
 
	return current;
}