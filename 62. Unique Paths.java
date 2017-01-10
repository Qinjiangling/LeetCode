public class Solution {
    
    public int uniquePaths(int m, int n) {
        int[][] paths = new int[m][n];
        paths[0][0] = 1;
        return dfs(m-1, n-1, paths);
    }
    
    public int dfs(int i, int j, int[][] paths){
        if(i < 0 || j < 0){
            return 0;
        }
        if(i == 0 && j == 0){
            return 1;
        }
        if(paths[i][j] > 0){
            return paths[i][j];
        }else{
            paths[i][j] = dfs(i-1, j, paths) + dfs(i, j-1, paths);
            return paths[i][j];
        }
    }
}