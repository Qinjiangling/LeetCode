public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        if(root == null){
            return ret;
        }
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode p = root;
        do{
            TreeNode pre = null;
            while(p != null){
                s.push(p);
                p = p.left;
            }
            while(!s.empty()){
                p = s.pop();
                //right is null or return from right
                if(p.right == pre){
                    ret.add(p.val);
                    pre = p;
                }else{
                    s.push(p);
                    //right first
                    p = p.right;
                    break;
                }
            }
        }while(!s.empty());
        
        return ret;
    }
}