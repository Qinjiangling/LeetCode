public class Solution {
    
    private boolean flag = false;
    
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)return false;
        preOrderTrace(root, 0, sum);
        return flag;
    }
    
    public void preOrderTrace(TreeNode root, int cur, int sum){
        if(root.left == null && root.right == null){
            if(cur + root.val == sum){
                flag = true;
            }
            return;
        }
        cur += root.val;
        if(root.left != null){
            preOrderTrace(root.left, cur, sum);
        }
        if(root.right != null){
            preOrderTrace(root.right, cur, sum);
        }
    }
}