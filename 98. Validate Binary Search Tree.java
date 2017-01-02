public class Solution {
    
    private int pre = Integer.MIN_VALUE;
    
    private boolean flag = false;
    //inOrder 
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        boolean ret = isValidBST(root.left);
        if(!ret){
            return ret;
        }
        if(root.val <= pre){
            if(flag){
                return false;
            }
        }
        pre = root.val;
        flag = true;
        return isValidBST(root.right);
    }
}