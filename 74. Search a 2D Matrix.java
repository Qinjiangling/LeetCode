public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int len = matrix.length;
        if(len == 0)return false;
        int i = 0, j = matrix[0].length - 1;
        while(i < len && j >= 0){
            int cur = matrix[i][j];
            if(cur == target){
                return true;
            } else if(cur > target){
                j -= 1;
            }else{
                i += 1;
            }
        }
        return false;
    }
}