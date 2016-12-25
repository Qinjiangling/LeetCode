import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return lists;
        }
        //sort
        Arrays.sort(nums);
        for(int i = 0; i <= nums.length - 3; i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            for(int j = i + 1; j <= nums.length -2 ; j++){
                if(nums[i] + nums[j] > 0){
                    break;
                }
                if(j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }
                int pos = binsearch(nums, j + 1, nums.length - 1, 0 - nums[i] - nums[j]);
                if(pos != -1){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[pos]);
                    lists.add(list);
                }
            }
        }
        return lists;
    }
    
    public int binsearch(int[] a, int s, int t, int target){
        if(s <= t){
            int mid = (s + t)/2;
            if(a[mid] > target){
                return binsearch(a, s, mid - 1, target);
            }else if(a[mid] < target){
                return binsearch(a, mid + 1, t, target);
            }else{
                return mid;
            }
        }
        return -1;
    }
}