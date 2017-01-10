public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null)return;
        Queue<TreeLinkNode> q = new LinkedList<>();
        q.add(root);
        TreeLinkNode pre =null;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 1; i <= size; i++){
                TreeLinkNode tmp = q.poll();
                if(i == 1){
                    pre = tmp;
                }else{
                    pre.next = tmp;
                    pre = tmp;
                }
                if(tmp.left != null)q.add(tmp.left);
                if(tmp.right != null)q.add(tmp.right);
            }
        }
    }
}