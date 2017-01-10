public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        if(len == 0)return null;
        return build(nums, 0, len-1);
    }
    
    public TreeNode build(int[] nums, int l, int r){
        if(l > r)return null;
        if(l == r)return new TreeNode(nums[l]);
        int mid = (l + r)>>1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums, l, mid-1);
        root.right = build(nums, mid+1, r);
        return root;
    }
}