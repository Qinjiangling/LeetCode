public class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        int i = 0, j = len - 1;
        int mArea = 0;
        while(i < j){
            int area = Math.min(height[i], height[j])*(j - i);
            if(area > mArea){
                mArea = area;
            }
            int h1 = height[i];
            int h2 = height[j];
            if(h1 < h2){
                do{
                    i++;
                }while(i < j && height[i] < h1);
            }else{
                do{
                    j--;
                }while(i < j && height[j] < h2);
            }
        }
        
        return mArea;
    }
}