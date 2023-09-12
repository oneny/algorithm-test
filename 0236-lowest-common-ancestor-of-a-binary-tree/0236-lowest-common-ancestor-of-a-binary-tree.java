/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    TreeNode answer = null;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        getCount(root, p, q);
        
        return answer;
    }
    
    public int getCount(TreeNode root, TreeNode p, TreeNode q) {
        int result = 0;
        
        if (root == null) return 0;
        
        if (root == p || root == q) {
            result = 1;
        }
        
        result += getCount(root.left, p , q);
        result += getCount(root.right, p, q);
        
        if (result == 2 && answer == null) {
            answer = root;
        }
        
        return result;
    }
}