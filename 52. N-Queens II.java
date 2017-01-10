public class Solution {
    
    int count = 0;
    
    public int totalNQueens(int n) {
        if(n <= 0)return count;
        int[] visited = new int[n];
        Arrays.fill(visited, -1);
        helper(visited, 0, n);
        return count;
    }
    
    public void helper(int[] visited, int cur, int n){
        if(cur == n){
            count++;
            return;
        }
        for(int pos = 0; pos < n; pos++){
            if(isValid(visited, cur, pos)){
                visited[cur] = pos;
                helper(visited, cur+1, n);
                visited[cur] = -1;
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