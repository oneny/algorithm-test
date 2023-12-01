import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int max = 0;
        int total = (1 + triangle[triangle.length - 1].length) * triangle.length / 2;
        
        for (int i = 1; i < triangle.length; i++) {
            int[] line = triangle[i];
            
            for (int j = 0; j < line.length; j++) {
                int index = (i) * (i + 1) / 2 + j;
                
                int preLeft = 0;
                int preRight = 0;
                if (j - 1 >= 0) {
                    preLeft = triangle[i - 1][j - 1];
                }
                if (j < line.length - 1) {
                    preRight = triangle[i - 1][j];
                }
                
                triangle[i][j] = triangle[i][j] + Math.max(preLeft, preRight);
                
                max = Math.max(triangle[i][j], max);
            }
        }
        
        return max;
    }
    
}