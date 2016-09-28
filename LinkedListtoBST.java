/*
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
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
    public TreeNode sortedListToBST(ListNode head) 
    {
        if(head==null) 
            return null;
    
        return toBST(head,null);
    }
    public TreeNode toBST(ListNode head, ListNode tail)
    {
        ListNode slow = head;
        ListNode fast = head;
        
        if(head==tail) 
			return null;
    
        while(fast!=tail&&fast.next!=tail)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode t_head = new TreeNode(slow.val);
        t_head.left = toBST(head,slow);
        t_head.right = toBST(slow.next,tail);
        return t_head;
	}
}