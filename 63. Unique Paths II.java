public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] grid = obstacleGrid;
        int m = grid.length;
        if(m == 0)return 0;
        int n = grid[0].length;
        int[][] path = new int[m][n];
        path[0][0] = 1;
        return dfs(m-1, n-1, grid, path);
    }
    
    public int dfs(int i, int j, int[][] grid, int[][] path){
        if(i < 0 || j < 0)return 0;
        if(grid[i][j] == 1)return 0;
        if(i == 0 && j == 0)return path[i][j];
        if(path[i][j] > 0){
            return path[i][j];
        }else{
            path[i][j] = dfs(i-1, j, grid, path) + dfs(i, j-1, grid, path);
            return path[i][j];
        }
    }
}