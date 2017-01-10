public class Solution {
    public List<String> restoreIpAddresses(String s) {
        Set<String> ret = new HashSet<String>();
        char[] chars = s.toCharArray();
        List<List<String>> lists = new ArrayList<>();
        helper(chars, lists, new ArrayList<String>(), 0, 0);
        for(List<String> strs : lists){
            StringBuffer buf = new StringBuffer();
            int i = 0;
            for(String str : strs){
                if(i == 0){
                    buf.append(str);
                }else{
                    buf.append(".").append(str);
                }
                i++;
            }
            ret.add(buf.toString());
        }
        return new ArrayList<String>(ret);
    }
    
    public void helper(char[] chars, List<List<String>> ret, List<String> list, int start, int cur){
        if(list.size() > 4)return;
        if(cur == chars.length){
            if(list.size() == 4){
                ret.add(new ArrayList<String>(list));
            }
            return;
        }
        for(int i = cur; i < chars.length; i++){
            if(i - start > 2)return;
            String tmp = String.valueOf(chars, start, i-start+1);
            if(tmp.length() > 1 && tmp.charAt(0) == '0')return;
            int num = Integer.valueOf(tmp);
            if(num > 255)return;
            //不截断
            if(i < chars.length - 1){
                helper(chars, ret, list, start, i+1);
            }
            list.add(tmp);
            helper(chars, ret, list, i+1, i+1);
            list.remove(list.size()-1);
        }
    }
}