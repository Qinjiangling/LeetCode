public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root == null)return list;
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(p != null){
            list.add(p.val);
            if(p.right != null)stack.push(p.right);
            p = p.left;
        }
        while(!stack.empty()){
            TreeNode tmp = stack.pop();
            while(tmp != null){
                list.add(tmp.val);
                if(tmp.right != null)stack.push(tmp.right);
                tmp = tmp.left;
            }
        }
        return list;
    }
}