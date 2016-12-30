public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int count = 0;
        for(int i = 0; i < len; i++){
            if(map.get(nums[i]) == null){
                nums[count] = nums[i];
                map.put(nums[i], 1);
                count++;
            }else if(map.get(nums[i]) < 2){
                nums[count] = nums[i];
                map.put(nums[i], 2);
                count++;
            }
        }
        
        return count;
    }
}