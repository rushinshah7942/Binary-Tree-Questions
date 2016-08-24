/*
	
	Approach: DFS (Depth First Search)

	For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
  
All root-to-leaf paths are:

["1->2->5", "1->3"]

*/

public class BinaryTreePaths 
{
    List<String> result = new ArrayList<String>();
    StringBuilder sb = new StringBuilder();
    
    public List<String> binaryTreePaths(TreeNode root) 
    {
        if(root == null)
            return result;
        
        int cntr = sb.length();
        if(root.left == null && root.right == null)
        {
            sb.append(root.val);
            result.add(sb.toString());
            sb.delete(cntr,sb.length());
        }    
        if(root.left != null)
        {
            sb.append(root.val);
            sb.append("->");
            binaryTreePaths(root.left);
            sb.delete(cntr,sb.length());
        }
        if(root.right != null)
        {
            sb.append(root.val);
            sb.append("->");
            binaryTreePaths(root.right);
            sb.delete(cntr,sb.length());            
        }

        return result;
    }
}