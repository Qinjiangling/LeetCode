public class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0)return 0;
        int len = nums.length, i = 0 , cur = 0;
        for(; i < len; i++){
            if(nums[i] != val){
                nums[cur] = nums[i];
                cur++;
            }
        }
        return cur;
    }
}