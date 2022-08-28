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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
                List<List<Integer>> res = new ArrayList();
        if(root == null) return res;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        boolean isEven = false;
        while(!q.isEmpty()){
            int levelNum = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<levelNum;i++){
                if(isEven){
                    TreeNode pop = q.pollLast();
                    list.add(pop.val);
                    if(pop.right != null) q.addFirst(pop.right);
                    if(pop.left != null) q.addFirst(pop.left);
                }else{
                    TreeNode pop = q.pollFirst();
                    list.add(pop.val);
                    if(pop.left != null) q.addLast(pop.left);
                    if(pop.right != null) q.addLast(pop.right);
                }
            }
            isEven = !isEven;
            res.add(list);
        }
        return res;
    }
}