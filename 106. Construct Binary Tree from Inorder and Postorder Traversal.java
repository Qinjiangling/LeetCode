public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    
    public TreeNode build(int[] in, int l1, int r1, int[] post, int l2, int r2){
        if(l1 > r1)return null;
        if(l1 == r1)return new TreeNode(in[l1]);
        //find
        int pos = -1;
        for(int i = l1; i <= r1; i++){
            if(in[i] == post[r2]){
                pos = i;
                break;
            }
        }
        TreeNode root = new TreeNode(post[r2]);
        int lSize = pos-l1, rSize=r1-pos;
        root.left = build(in, l1, pos-1, post, r2-rSize-1-lSize, r2-rSize-1);
        root.right = build(in, pos+1, r1, post, r2-rSize, r2-1);
        return root;
    }
}