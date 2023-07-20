class Solution {
    public int numIslands(char[][] grid) {
        int result = 0;
        
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == '1') {
                    result++;
                    mark(grid, row, col);
                }
            }
        }
        
        return result;
    }
    
    public static void mark(char[][] grid, int row, int col) {
        grid[row][col] = '-';
        // up
        if (row > 0 && grid[row - 1][col] == '1') mark(grid, row - 1, col);
        
        // down
        if (row < grid.length - 1 && grid[row + 1][col] == '1') mark(grid, row + 1, col);
        
        // left
        if (col > 0 && grid[row][col - 1] == '1') mark(grid, row, col - 1);
        
        // right
        if (col < grid[0].length - 1 && grid[row][col + 1] == '1') mark(grid, row, col + 1);
    }
}