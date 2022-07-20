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
    public static boolean isSymmetric(TreeNode root) {
        List<Integer> left = depthFirstSearch(root.left, false);
        List<Integer> right = depthFirstSearch(root.right, true);
        return left.equals(right);
    }


    public static List<Integer> depthFirstSearch(TreeNode root, boolean isLeftOriented) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> elements = new ArrayList<>();
        if(root == null) {
            return new ArrayList<>();
        }
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode current = stack.pop();
            elements.add(current == null? Integer.MIN_VALUE : current.val);
            if (current == null){
                continue;
            }

            stack.push(isLeftOriented ? current.left: current.right );

            TreeNode secondChild = isLeftOriented? current.right: current.left;
            stack.push(isLeftOriented ? current.right: current.left );


        }
        return elements;
    }
}