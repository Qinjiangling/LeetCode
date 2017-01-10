public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0)return false;
        if(x == 0)return true;
        int data = x;
        int len = 0;
        do{
            data /= 10;
            len++;
        }while(data > 0);
        int k = len/2;
        len--;
        while(k > 0){
            int tmp = (int)Math.pow((double)10,(double)len);
            int a = x % 10;
            int b = x/tmp;
            if(a != b)return false;
            x -= a*tmp;
            x /= 10;
            len -= 2;
            k--;
        }
        return true;
    }
}