class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dp = new int[rows][cols];

        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, 0, rows, cols, grid, dp);
    }
    public int solve(int i, int j, int rows, int cols,
                     int[][] grid, int[][] dp) {

        if(i >= rows || j >= cols) {
            return Integer.MAX_VALUE;
        }

        // Out of grid
        
        if(i == rows-1 && j == cols-1) {
            return grid[i][j];
        }
        
        // Memoization check
        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        // Move Down
        int down = solve(i+1, j, rows, cols, grid, dp);

        // Move Right
        int right =solve(i, j+1, rows, cols, grid, dp);

        // Store and return result
        return dp[i][j] = grid[i][j] + Math.min(down, right);
    }
}