public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ret = new ArrayList<>();
        char[] chars = s.toCharArray();
        helper(ret, new ArrayList<String>(), chars, 0, 0);
        return ret;
    }
    
    public void helper(List<List<String>> ret, List<String> list, char[] chars, int cur, int start){
        if(cur == chars.length){
            ret.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i <= 1; i++){
            if(i == 0){
                if(!isPalindrome(chars, start, cur))continue;
                list.add(String.valueOf(chars, start, cur - start + 1));
                helper(ret, list, chars, cur+1, cur+1);
                list.remove(list.size()-1);
            }else{
                if(cur < chars.length - 1)helper(ret, list, chars, cur+1, start);
            }
        }
    }
    
    public boolean isPalindrome(char[] chars, int i, int j){
        while(i <= j){
            if(chars[i++] != chars[j--])return false;
        }
        return true;
    }
}