public class Solution {
 public int myAtoi(String str) {
        if(str == null || str.length() == 0){
            return 0;
        }
        char[] s = str.toCharArray();
        int len = s.length;
        long ret = 0;
        int i = 0, flag = 1;
        //space
        while(s[i] == ' '){
            i++;
        }
        if(s[i] == '-'){
            flag = 0;
            i++;
        }else if(s[i] == '+'){
            i++;
        }
        while(i < len){
            if(s[i] > '9' || s[i] < '0'){
                break;
            }
            ret = ret*10 + s[i] - '0';
            i++;
            if(flag == 1 && ret >= 2147483647L){
                ret = 2147483647;
                break;
            }
            if(flag == 0 && ret >= 2147483648L){
                ret = 2147483648L;
                break;
            }
        }
        if(flag == 0){
            ret = -ret;
        }
        
        return (int)ret;
    }
}