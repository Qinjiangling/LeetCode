public class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0 || s.length() == 1){
            return s;
        }
        int len = s.length();
        int step = len - 1;
        while(step > 0){
            for(int i = 0; i < len; i++){
               int j = i + step;
               if(j >= len){
                   break;
               }
               if(isPalindrome(s, i, j)){
                  return s.substring(i,j+1);
               }
            }
            step--;
        }
        
        return s.substring(0,1);
     }
    
    public boolean isPalindrome(String s, int i, int j){
        while(i <= j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}