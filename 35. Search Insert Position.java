public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0){
            return 0;
        }
        int len = nums.length;
        int i = 0, j = len - 1;
        int mid = 0;
        while(i <= j){
            mid = (i + j)/2;
            if(nums[mid] > target){
                j = mid - 1;
            }else if(nums[mid] < target){
                i = mid + 1;
            }else{
                return mid;
            }
        }
        //not found
        if(j == mid - 1){
            return mid;
        }else{
            return i;
        }
    }
}