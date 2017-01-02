public class Solution {
    private boolean flag = true;
    
    public boolean isBalanced(TreeNode root) {
        backTrace(root);
        return flag;
    }
    
    public int backTrace(TreeNode root){
        if(root == null){
            return 0;
        }
        int h1 = backTrace(root.left);
        int h2 = backTrace(root.right);
        if(Math.abs(h1 - h2) > 1){
            flag = false;
        }
        return h1>h2?h1+1:h2+1;
    }
}