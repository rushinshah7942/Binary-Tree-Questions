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
		}// add node value here, after adding all the left and right values
		result.add(level);
	}
	return result;
}	
/*
If you think about it, in a tree with n nodes, there's no possible way that you can ever get any more than n nodes into the queue at any one time, since no node will ever be enqueued twice. This gives an immediate upper bound of O(n). This isn't a tight bound, though, since if the tree is a degenerate linked list then the memory usage will just be O(1).

Your upper bound of O(2^h) is also correct, but it's a weaker upper bound. In a tree with height h, there can be at most 2h nodes in the bottom layer, but there's no guarantee that this is actually the case. If the tree is a degenerate linked list, the height is O(n), and your bound of O(2^h) will exponentially overapproximate the memory usage.

Therefore, your bound is correct, but O(n) is a much better bound.
*/ 
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