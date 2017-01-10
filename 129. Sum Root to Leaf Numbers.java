public class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null)return 0;
        preOrder(root, new ArrayList<Integer>());
        return sum;
    }
    
    public void preOrder(TreeNode root, List<Integer> list){
        if(root == null)return;
        list.add(root.val);
        if(root.left == null && root.right == null){
            int tmp = 0;
            for(int num : list){
                tmp = tmp*10 + num;
            }
            sum += tmp;
            list.remove(list.size() - 1);
            return;
        }
        preOrder(root.left, list);
        preOrder(root.right, list);
        list.remove(list.size() - 1);
    }
}