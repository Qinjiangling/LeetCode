public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        if(root == null){
            return ret;
        }
        TreeNode p = root; 
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(p != null){
            stack.push(p);
            p = p.left;
        }
        int flag = 0;
        while(!stack.empty()){
            TreeNode tmp = stack.pop();
            if(flag == 0){
                ret.add(tmp.val);
                //right tree
                if(tmp.right != null){
                    stack.push(tmp.right);
                    flag = 1;
                }
            }else{
                while(tmp != null){
                    stack.push(tmp);
                    tmp = tmp.left;
                }
                flag = 0;
            }
        }
        return ret;
    }
}