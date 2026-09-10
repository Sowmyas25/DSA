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
    private int count = 0;
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return count;
    }

    // Returns {sum of subtree, number of nodes in subtree}
    private long[] dfs(TreeNode node) {
        if (node == null) return new long[]{0, 0};

        long[] left = dfs(node.left);
        long[] right = dfs(node.right);

        long sum = left[0] + right[0] + node.val;
        long nodes = left[1] + right[1] + 1;

        // Average rounded down (integer division)
        if (node.val == sum / nodes) {
            count++;
        }

        return new long[]{sum, nodes};
    }
}