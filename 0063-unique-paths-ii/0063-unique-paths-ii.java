class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        int [][] dp = new int[rows][cols];

        for(int [] row : dp){
            Arrays.fill(row, -1);
        }
    
        return solve(0, 0, rows, cols, obstacleGrid, dp);
    }

    public int solve(int i, int j, int rows, int cols,int[][] obstacleGrid, int[][] dp){
        if(i >= rows || j >= cols){
            return 0;
        }

        if(obstacleGrid[i][j] == 1) return 0;

        if(i == rows-1 && j == cols-1){
            return 1;
        }

        if(dp[i][j] != -1) return dp[i][j];

        int down = solve(i+1, j, rows, cols, obstacleGrid, dp);
        int right = solve(i, j+1, rows, cols, obstacleGrid, dp);

        return dp[i][j] = down+right;
    }
}