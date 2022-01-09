//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1080 👎 0


package cn;


import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfBinaryTree().new Solution();
        Integer[] arr = new Integer []{3,9,20,null,null,15,7};
        TreeNode treeNode = new MaximumDepthOfBinaryTree().new TreeNode();

        for (int i = 0; i < arr.length; i++) {
            treeNode.insertNode(arr[i]);
        }

        System.out.println(treeNode);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public int maxDepth(TreeNode root) {
            if(root == null){
                return 0;
            }
            return Math.max(maxDepth(root.left)+1,maxDepth(root.right)+1);
        }
    }

    public  class TreeNode {
        Integer val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(Integer val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public void insertNode(Integer val){
            insertNode(this,val);
        }

        private void insertNode(TreeNode tree,Integer val){
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            if(tree.val == null){
                tree.val = val;
            }else{
                queue.add(tree);
            }
            while (!queue.isEmpty()){
                tree = queue.remove();
                if(tree.left == null){
                    tree.left = new TreeNode(val);
                    break;
                }else{
                    queue.add(tree.left);
                }
                if(tree.right == null){
                    tree.right = new TreeNode(val);
                    break;
                }else{
                    queue.add(tree.right);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}