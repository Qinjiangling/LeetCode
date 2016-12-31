public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ret = {-1, -1};
        if(nums == null || nums.length == 0){
            return ret;
        }
        ret[0] = bound(nums, target, 0);
        if(ret[0] == -1)return ret;
        ret[1] = bound(nums, target, 1);
        return ret;
    }
    
    public int bound(int[] nums, int target, int flag){
        int len = nums.length;
        int i = 0, j = len - 1, ret = -1;
        while(i <= j){
            int mid = (i + j)/2;
            if(nums[mid] > target){
                j = mid - 1;
            }else if(nums[mid] < target){
                i = mid + 1;
            }else{
                ret = mid;
                if(flag == 0){
                    j = mid - 1;
                }else{
                    i = mid + 1;
                }
            }
        }
        return ret;
    }
}