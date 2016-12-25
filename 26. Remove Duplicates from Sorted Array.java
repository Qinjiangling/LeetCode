public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return 1;
        }
        //from the end of array
        int len = nums.length;
        int ret = 1;
        int pre = nums[len - 1];
        int i = len - 2;
        int j = len - 2;
        for(; i >= 0; i--){
            if(nums[i] != pre){
                nums[j] = nums[i];
                pre = nums[i];
                j--;
                ret++;
            }
        }
        //copy
        i = 0;
        j = j + 1;
        while(j < len){
            nums[i++] = nums[j++];
        }
        
        return ret;
    }
}