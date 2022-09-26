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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }

        if(root == p || root == q){
            return root;
        }

        TreeNode lNode = lowestCommonAncestor (root.left, p, q);
        TreeNode rNode = lowestCommonAncestor(root.right, p, q);


        if (lNode == null && rNode==null) {
            return null;
        }

        if (lNode != null && rNode!=null) {
            return root;
        }

        return lNode == null ? rNode : lNode;
    }
}