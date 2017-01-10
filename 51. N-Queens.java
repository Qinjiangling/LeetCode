public class Solution {
    
    private char[] chars;
    
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ret = new ArrayList<>();
        if(n <= 0)return ret;
        chars =  new char[n];
        for(int i = 0; i < n; i++){
            chars[i] = '.';
        }
        int[] visited = new int[n];
        Arrays.fill(visited, -1);
        helper(ret, new ArrayList<String>(), visited, 0, n);
        return ret;
    }
    
    public void helper(List<List<String>> ret, List<String> list, int[] visited, int cur, int n){
        if(cur == n){
            ret.add(new ArrayList<String>(list));
            return;
        }
        for(int pos = 0; pos < n; pos++){
            if(isValid(visited, cur, pos)){
                chars[pos] = 'Q';
                list.add(String.valueOf(chars));
                chars[pos] = '.';
                visited[cur] = pos;
                helper(ret, list, visited, cur+1, n);
                visited[cur] = -1;
                list.remove(list.size()-1);
            }
        }
    }
    
    public boolean isValid(int[] a, int row, int col){
        for(int i = 0; i < row; i++){
            if(a[i] == col)return false;
            if(Math.abs(row - i) == Math.abs(a[i] - col))return false;
        }
        return true;
    }
}