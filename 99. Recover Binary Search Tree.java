public class Solution {
    private TreeNode tail = null;
    
    public void recoverTree(TreeNode root) {
        if(root == null)return;
        if(root.left == null && root.right == null)return;
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> r = new ArrayList<Integer>();
        list.add(Integer.MIN_VALUE);
        inOrderFind(root, list, r);
        if(r.size() == 1){
            r.add(tail.val);
        }
        int m = r.get(0), n = r.get(1);
        inOrderChange(root, m, n);
    }
    
    public void inOrderFind(TreeNode root, List<Integer> list, List<Integer> r){
        if(root == null){
            return;
        }
        inOrderFind(root.left, list, r);
        list.add(root.val);
        int len = list.size();
        if(list.get(len-2) > list.get(len-1) && r.size() == 0){
            r.add(list.get(len-2));
        }
        if(list.get(len-1) < list.get(len-2)){
            if(r.size() == 1){
                r.add(list.get(len-1));
            }else{
                r.set(1, list.get(len-1));
            }
        }
        tail = root;
        inOrderFind(root.right, list, r);
    }
    
    public void inOrderChange(TreeNode root, int m, int n){
        if(root == null){
            return;
        }
        inOrderChange(root.left, m, n);
        if(root.val == m){
            root.val = n;
        }else if(root.val == n){
            root.val = m;
        }
        inOrderChange(root.right, m, n);
    }
}