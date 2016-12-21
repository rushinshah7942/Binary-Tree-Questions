/*
Given a complete binary tree, count the number of nodes.	
*/

// O(n)

public int countNodes(TreeNode root) {
    if (root == null)
        return 0;
    return 1 + countNodes(root.left) + countNodes(root.right)
}

/*
Since always at least one of the two recursive calls is such a full tree, at least one of the two calls immediately stops. Again we have runtime O(log(n)^2). ie. Time complexity is O(h^2).
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

	public int countNodes(TreeNode root) {
        
        TreeNode left = root;
        TreeNode right = root;
        
        int leftCount = 0;
        int rightCount = 0;
        
        while(left!=null){
            leftCount++;
            left = left.left;
        } // log n
        
        while(right!=null){
            rightCount++;
            right = right.right;
        }
        if(leftCount == rightCount){
            return (int)Math.pow(2,leftCount)-1;
        }
   
        return 1+countNodes(root.left)+countNodes(root.right);
        
    }
}

// We can just use one of the loop to determine height, as we have complete tree.
// use right one, as in complete tree, and all nodes in the last level are as far left as possible

public class Solution {
    public int countNodes(TreeNode root) {
       if (root == null)
            return 0;
        TreeNode left = root, right = root;
        int height = 0;
        
        while (right != null) {
            left = left.left;
            right = right.right;
            height++;
        }
        
        if (left == null)
            return (1 << height) - 1;
        
        return 1 + countNodes(root.left) + countNodes(root.right); 
    }
}

