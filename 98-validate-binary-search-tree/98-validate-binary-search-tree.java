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
    
    
    
    public static boolean isValidBST(TreeNode root) {
            //return isValidBSTRecursive(root, null, null);
            return isValidBSTInOrderTraversal(root);
        }
    
        public static boolean isValidBSTInOrderTraversal(TreeNode root) {
            List<Integer> elements = inOrderTraversal(root, new ArrayList<>());
            return isSorted(elements);
        }
    
        private static boolean isSorted(List<Integer> elements) {
            Integer prev = null;
            for (Integer current :
                 elements) {
                if(prev!=null && prev >= current) {
                    return false;
                }
                prev = current;
            }
            return true;
        }
    
        public static List<Integer> inOrderTraversal(TreeNode root, List<Integer> elements){
            if (root == null) {
                return  elements;
            }
            List<Integer> elemAfterLeft = inOrderTraversal(root.left, elements);
            elemAfterLeft.add(root.val);
            return inOrderTraversal(root.right, elemAfterLeft);
        }
//      public static boolean isValidBST(TreeNode root) {
//         return isValidBST(root, null, null);
//     }


//     public static boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
//         if(root == null){
//             return true;
//         }
//         if (min != null && root.val <= min.val){
//             return false;
//         }
//         if (max != null && root.val >= max.val){
//             return false;
//         }
//         return  isValidBST(root.left, min , root ) && isValidBST(root.right, root, max);
//     }
}