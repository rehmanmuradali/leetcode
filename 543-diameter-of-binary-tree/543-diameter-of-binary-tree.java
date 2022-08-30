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
    public static int diameterOfBinaryTree(TreeNode root) {

        int[] result = new int[1];
        diameterOfBT(root, result);
        return result[0];
    }

    public static int diameterOfBT(TreeNode root, int[] result) {
        if(root == null) return 0;
        int left = diameterOfBT(root.left, result);
        int right = diameterOfBT(root.right, result);
        result[0] = Math.max(result[0], left + right);

        return Math.max(left, right) + 1;
    }
}