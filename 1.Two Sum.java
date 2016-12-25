public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return null;
        }
        int[] ret = new int[2];
        int pos;
        for(int i = 0; i < nums.length; i++){
            if((pos = search(nums, i + 1, target - nums[i])) != -1){
                ret[0] = i;
                ret[1] = pos;
                break;
            }
        }
        return ret;
    }
    
    public int search(int[] a, int sta, int target){
        for(int i = sta; i < a.length; i++){
            if(a[i] == target){
                return i;
            }
        }
        return -1;
    }
}