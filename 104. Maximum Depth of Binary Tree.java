public class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null)return 0;
        int dp1 = maxDepth(root.left);
        int dp2 = maxDepth(root.right);
        return Math.max(dp1, dp2) + 1;
    }
}