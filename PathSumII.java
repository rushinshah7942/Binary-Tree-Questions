/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
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
public class Solution 
{
    public List<List<Integer>> pathSum(TreeNode root, int sum)
    {
	    List<List<Integer>> result  = new LinkedList<List<Integer>>();
    	List<Integer> currentResult  = new LinkedList<Integer>();
    	pathSum(root,sum,currentResult,result);
    	return result;
    }

    public void pathSum(TreeNode root, int sum, List<Integer> currentResult,List<List<Integer>> result) 
	{
	    if (root == null)
	    	return;
	    
	    currentResult.add(root.val);

	    if (root.left == null && root.right == null && sum == root.val) // found leaf 
	    {
		    result.add(new LinkedList(currentResult));
		    currentResult.remove(currentResult.size()-1); //don't forget to remove the last integer
		    return;
	    } 
	    else 
	    {
	    	pathSum(root.left, sum - root.val, currentResult, result);
	    	pathSum(root.right, sum - root.val, currentResult, result);
	    }
		
	    currentResult.remove(currentResult.size()-1); //don't forget to remove the last integer
    }
}

/*
Nice solution with back-tracking. I think you could make it more elegant by removing

currentResult.remove(currentResult.size() - 1);//don't forget to remove the last integer
return;
This is because after finishing the statements in if, we will never walk into else. So it is not necessary to use return here.

Also using ArrayList allows O(1) access to the each node, that means removing the last element takes only O(1). 
If you use LinkedList, initially we have traverse the list to the last node then remove it, which takes O(n) time.
*/

public List<List<Integer>> pathSum(TreeNode root, int sum) 
{
    List<List<Integer>>ret = new ArrayList<List<Integer>>(); 
    List<Integer> cur = new ArrayList<Integer>(); 
    pathSum(root, sum, cur, ret);
    return ret;
}

public void pathSum(TreeNode root, int sum, List<Integer>cur, List<List<Integer>>ret){
    if (root == null){
        return; 
    }
    cur.add(root.val);
	
    if (root.left == null && root.right == null && root.val == sum){
        ret.add(new ArrayList(cur));
    }else{
        pathSum(root.left, sum - root.val, cur, ret);
        pathSum(root.right, sum - root.val, cur, ret);
    }
    cur.remove(cur.size()-1);
}