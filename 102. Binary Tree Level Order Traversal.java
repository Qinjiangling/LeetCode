public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null){
            return ret;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        TreeNode pre = root, cur = null;
        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode tmp = q.poll();
            list.add(tmp.val);
            if(tmp.left != null){
                q.add(tmp.left);
                cur = tmp.left;
            }
            if(tmp.right != null){
                q.add(tmp.right);
                cur = tmp.right;
            }
            if(tmp == pre){
                pre = cur;
                ret.add(new ArrayList<Integer>(list));
                list.clear();
            }
        }
        return ret;
    }
}