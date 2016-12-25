public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return lists;
        }
        solution(lists, nums, 0, nums.length);
        return lists;
    }
    
    public void solution(List<List<Integer>> lists, int[] nums, int cur, int len){
        if(cur == len){
            List<Integer> list = new ArrayList<Integer>();
            for(int i = 0; i < len; i++){
                list.add(nums[i]);
            }
            lists.add(list);
            return;
        }
        for(int i = cur; i < len; i++){
            int tmp = nums[cur];
            nums[cur] = nums[i];
            nums[i] = tmp;
            solution(lists, nums, cur + 1, len);
            tmp = nums[cur];
            nums[cur] = nums[i];
            nums[i] = tmp;
        }
    }
}