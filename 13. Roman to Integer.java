import java.util.Map;
import java.util.HashMap;
public class Solution {
    public int romanToInt(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        char[] data = {'I','V','X','L','C','D','M'};
        Map<Character, Integer> map1 = new HashMap<Character,Integer>();
        int len1 = data.length;
        for(int i = 0; i < len1; i++){
            map1.put(data[i], i);
        }
        Map<Character, Integer> map2 = new HashMap<Character,Integer>();
        map2.put('I',1);
        map2.put('V',5);
        map2.put('X',10);
        map2.put('L',50);
        map2.put('C',100);
        map2.put('D',500);
        map2.put('M',1000);
        char[] str = s.toCharArray();
        int len = str.length;
        if(len == 1){
            return map2.get(str[0]);
        }
        int i = len - 1, j = len - 2;
        int ret = 0;
        while(j >= 0){
            if(map1.get(str[i]) <= map1.get(str[j])){
                ret += map2.get(str[i]);
                i = j;
                j--;
            }else{
                ret += map2.get(str[i]) - map2.get(str[j]);
                j -= 2;
                i -= 2;
            }
        }
        if(i == 0){
            ret += map2.get(str[i]);
        }
        
        return ret;
    }
}