public class Solution {
    
    private TreeNode pre = null;
    
    public void flatten(TreeNode root) {
        if(root == null)return;
        preOrderTrace(root);
    }
    
    public TreeNode preOrderTrace(TreeNode root){
        if(root == null)return null;
        if(pre != null){
            pre.right = root;
            pre.left = null;
        }
        pre = root;
        TreeNode right = root.right;
        preOrderTrace(root.left);
        preOrderTrace(right);
        return root;
    }
}