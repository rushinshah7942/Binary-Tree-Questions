/*
Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        
        int sum = 0;
        
        if(root == null)
            return sum;
            
        if(root.left == null && root.right == null)
            return sum;
        
        Stack<TreeNode> stack = new Stack<>();
        boolean leftOrNot = false;
        
        TreeNode node = root;
        
        while(true){
            
            if(node!= null && node.left == null && node.right == null && leftOrNot == true)
                sum+= node.val;
            
            if(node !=null)
            {
                leftOrNot = true;
                stack.push(node);
                node = node.left;
            }
            else
            {
                if(stack.isEmpty())
                    break;
                
                node = stack.pop();
                node= node.right;
                leftOrNot= false;
            }
        }
        return sum;
    }
}


// Recursive

public int sumOfLeftLeaves(TreeNode root) {
    if(root == null) 
		return 0;
 
	int ans = 0;
    if(root.left != null) {
        if(root.left.left == null && root.left.right == null) 
			ans += root.left.val;
        else 
			ans += sumOfLeftLeaves(root.left);
    }
    ans += sumOfLeftLeaves(root.right);
    
    return ans;
}