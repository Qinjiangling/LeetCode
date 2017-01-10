public class Solution {
    public int strStr(String haystack, String needle) {
        if(Objects.equals(haystack, needle))return 0;
        int len1 = haystack.length(), len2 = needle.length();
        for(int i = 0; i < len1; i++){
            int j = i, k = 0;
            for(; j < len1 && k < len2; j++,k++){
                if(haystack.charAt(j) != needle.charAt(k))break;
            }
            if(k == len2)return i;
        }
        return -1;
    }
}