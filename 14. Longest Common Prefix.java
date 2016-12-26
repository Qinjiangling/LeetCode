public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        int len = strs.length;
        if(len == 1){
            return strs[0];
        }
        String tmp = strs[0];
        for(int i = 1; i < len; i++){
            tmp = maxStr(tmp, strs[i]);
            if("".equals(tmp)){
                return tmp;
            }
        }
        
        return tmp;
    }
    
    public String maxStr(String s1, String s2){
        int len1 = s1.length(), len2 = s2.length();
        int i = 0;
        for(; i < len1 && i < len2; i++){
            if(s1.charAt(i) != s2.charAt(i)){
                break;
            }
        }
        if(i == 0){
            return "";
        }else{
            return s1.substring(0,i);
        }
    }
}