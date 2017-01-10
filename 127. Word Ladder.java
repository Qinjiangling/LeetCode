public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Queue<String> toVisit = new LinkedList<String>();
        findNeighbors(toVisit, wordList, beginWord);
        int len = 1;
        while(!toVisit.isEmpty()){
            int count = toVisit.size();
            for(int i = 0; i < count; i++){
                String str = toVisit.poll();
                if(endWord.equals(str)){
                    return len + 1;
                }
                findNeighbors(toVisit, wordList, str);
            }
            len++;
        }
        return 0;
    }
    
    public void findNeighbors(Queue<String> queue, Set<String> wordList, String cur){
        wordList.remove(cur);
        char[] chars = cur.toCharArray();
        int len = chars.length;
        for(int pos = 0; pos < len; pos++){
            char tmp = chars[pos];
            for(char c = 'a'; c <= 'z'; c++){
                chars[pos] = c;
                String s = String.valueOf(chars);
                if(wordList.contains(s)){
                    queue.add(s);
                    wordList.remove(s);
                }
            }
            chars[pos] = tmp;
        }
    }
}