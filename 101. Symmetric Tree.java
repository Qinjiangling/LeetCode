public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)return true;
        TreeNode p = preOrderSym(root);
        return sameTree(root, p);
    }
    
    public TreeNode preOrderSym(TreeNode root){
        if(root == null)return null;
        TreeNode node = new TreeNode(root.val);
        node.right = preOrderSym(root.left);
        node.left = preOrderSym(root.right);
        return node;
    }
    
    public boolean sameTree(TreeNode r1, TreeNode r2){
        if(r1 == null && r2 == null)return true;
        if(r1 == null || r2 == null)return false;
        if(r1.val != r2.val)return false;
        return sameTree(r1.left, r2.left) && sameTree(r1.right, r2.right);
    }
}