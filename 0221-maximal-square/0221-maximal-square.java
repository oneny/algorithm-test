class Solution {
    
    public int maximalSquare(char[][] matrix) {
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        int[][] dp = new int[n + 1][m + 1];
        int max = 0;
        
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= m; col++) {
                if (matrix[row - 1][col - 1] == '1') {
                    dp[row][col] = Math.min(dp[row - 1][col], Math.min(dp[row - 1][col - 1], dp[row][col - 1])) + 1;
                }
                
                max = Math.max(dp[row][col], max);
            }
        }
        
        return max * max;
    }
    
}