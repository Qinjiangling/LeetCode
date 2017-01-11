public class Solution {
    public int climbStairs(int n) {
        if(n == 1)return 1;
        if(n == 2)return 2;
        int pre = 2, ppre = 1, ret = 0;
        for(int i = 3; i <= n; i++){
            ret = pre + ppre;
            ppre = pre;
            pre = ret;
        }
        return ret;
    }
}