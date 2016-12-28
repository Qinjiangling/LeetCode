public class Solution {
    public int reverse(int x) {
        boolean flag = false;
        if(x < 0){
            flag = true;
            x = -x;
        }
        List<Integer> list = new ArrayList<Integer>();
        do{
            list.add(x%10);
        }while((x /= 10)>0);
        int k = 1, len = list.size() - 1;
        int ret = 0;
        while(len >= 0){
            if(len == 0 && list.get(len) > 2 && list.size() == 10){
                return 0;
            }
            int tmp = k*list.get(len);
            if(Integer.MAX_VALUE - tmp < ret){
                return 0;
            }
            ret += tmp;
            k *= 10;
            len--;
        }
        if(flag){
            ret = -ret;
        }
        return ret;
    }
}