/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int val = 0;
            int size = queue.size(); // 해당 뎁스때의 개수를 기억해야함
            
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode == null) break;
                
                if (i == size - 1) result.add(currentNode.val);
                
                if (currentNode.left != null) queue.add(currentNode.left);
                if (currentNode.right != null) queue.add(currentNode.right);
            }
        }
        
        return result;
    }
}