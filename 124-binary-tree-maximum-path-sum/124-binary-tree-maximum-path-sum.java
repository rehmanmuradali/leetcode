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
   public static int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        maxPath(root, max);
        return Math.max(max[0], maxPath(root, max));
    }
    public static int maxPath(TreeNode root, int[] max) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int left = maxPath(root.left, max);
        int right = maxPath(root.right, max);
        if (left < 0) left = 0;
        if (right < 0) right = 0;

        int resultRootAsCurrentNode = root.val + left + right;
        max[0] = Math.max(Math.max(max[0], resultRootAsCurrentNode), root.val);
        return Math.max(left, right) + root.val;
    }



}