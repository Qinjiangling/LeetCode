public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0)return null;
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    public TreeNode build(int[] pre, int s1, int e1, int[] in, int s2, int e2){
        if(s1 <= e1){
            TreeNode root = new TreeNode(pre[s1]);
            int pos = findPos(in, s2, e2, pre[s1]);
            int leftTreeLen = pos - s2, rightTreeLen = e2 - pos;
            root.left = build(pre, s1+1, s1+leftTreeLen, in, s2, pos-1);
            root.right = build(pre, s1+leftTreeLen+1, e1, in, pos + 1, e2);
            return root;
        }
        return null;
    }
    
    public int findPos(int[] in, int i, int j, int k){
        while(i <= j){
            if(in[i] == k)return i;
            i++;
        }
        return -1;
    }
}