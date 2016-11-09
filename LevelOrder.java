/*
	Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
	
	We need to keep track of 2 LinkedList 
		- Current level nodes	
		- Next level nodes (left and right children of current node)
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

 
// using Queue - Straight-forward 
 
public List<List<Integer>> levelOrder(TreeNode root){
	List<List<>> result = new ArrayList<>();
	
	if(root == null)
			return result;
	
	Queue<TreeNode> queue = new LinkedList<>();
	queue.add(root);
	
	while(!queue.isEmpty()){
		List<Integer> level = new ArrayList<>();
		int count = queue.size();
		
		// to add level-wise
		// we keep count of current state of queue, i.e before going to next level
		for(int i=0;i<count;i++){
			TreeNode node = queue.poll();
			level.add(node.val);
			if(node.left != null){
				queue.offer(node.left);
			}
			if(node.right!=null){
				queue.offer(node.right);
			}
		}
		result.add(level);
	}
	return result;
}	
 
public List<List<Integer>> levelOrder(TreeNode root) 
{
	List<List<Integer>> result = new ArrayList<List<Integer>>();
	List<Integer> nodeValues = new ArrayList<Integer>();
	
	if(root == null)
		return result;
	
	// use current and next queues
	
	LinkedList<TreeNode> current = new LinkedList<TreeNode>();
	LinkedList<TreeNode> next = new LinkedList<TreeNode>();
	
	current.add(root);
	
	while(!current.isEmpty())
	{
		TreeNode node = current.remove();
		// remove method retireves and removes head of the LinkedList (As we are going from left to right, we use remove method).
		
		// if we want to go from right child to left child, simply change order below
		// i.e. add right child first instead of left child
		if(node.left != null)
			next.add(node.left);
		if(node.right != null)
			next.add(node.right);
			
		nodeValues.add(node.val); // integer
		
		if(current.isEmpty())
		{
			current = next;
			next = new LinkedList<TreeNode>();
			result.add(nodeValues);
			nodeValues = new ArrayList();
		}
	}
	return result;
}