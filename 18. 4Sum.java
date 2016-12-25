import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return lists;
        }
        Arrays.sort(nums);
        for(int i = 0; i <= nums.length - 4; i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            for(int j = i + 1; j <= nums.length - 3; j++){
                if(j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }
                for(int k = j + 1; k <= nums.length - 2; k++){
                    if(k > j + 1 && nums[k] == nums[k - 1]){
                        continue;
                    }
                    int pos = binsearch(nums, k + 1, nums.length - 1, target - nums[i] - nums[j] - nums[k]);
                    if(pos != -1){
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[pos]);
                        lists.add(list);
                    }
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