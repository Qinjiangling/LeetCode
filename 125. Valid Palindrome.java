public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0){
            return true;
        }
        StringBuffer str = new StringBuffer();
        int len = s.length(), i = 0;
        while(i < len){
            char c = s.charAt(i++);
            if(c >= 'A' && c <= 'Z'){
                str.append((char)(c + 'a' - 'A'));
            }else if((c >= 'a' && c <= 'z') || c >= '0' && c <= '9'){
                str.append(c);
            }
        }
        int count = str.length();
        if(count == 0){
            return true;
        }
        for(int j = 0, k = count - 1; j <= k; j++, k--){
            if(str.charAt(j) != str.charAt(k)){
                return false;
            }
        }
        return true;
    }
}