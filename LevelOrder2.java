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
    public List<List<Integer>> levelOrderBottom(TreeNode root) 
    {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    ArrayList<Integer> nodeValues = new ArrayList<Integer>();
    if(root == null)
        return al;
 
    LinkedList<TreeNode> current = new LinkedList<TreeNode>();
    LinkedList<TreeNode> next = new LinkedList<TreeNode>();
    current.add(root);
 
    while(!current.isEmpty())
    {
        TreeNode node = current.remove();
 
        if(node.left != null)
            next.add(node.left);
        if(node.right != null)
            next.add(node.right);
 
        nodeValues.add(node.val);
        if(current.isEmpty())
        {
            current = next;
            next = new LinkedList<TreeNode>(); // empty the next node
            result.add(nodeValues);
            nodeValues = new ArrayList();
        }
 
    }
    Collections.reverse(result);
    return result;    
    }
}