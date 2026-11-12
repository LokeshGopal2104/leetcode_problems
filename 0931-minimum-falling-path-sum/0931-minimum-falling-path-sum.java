class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dp = new int[rows][cols];
        boolean[][] visited = new boolean[rows][cols];

        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int mini = Integer.MAX_VALUE;

        for(int i = 0; i< cols; i++){
            mini = Math.min(mini, solve(0, i, rows, cols, matrix, dp, visited));
        }
        return mini;
    }
    public int solve(int i, int j, int rows, int cols, int[][] matrix, int [][] dp, boolean[][] visited){

        if(i >= rows || j >= cols || i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }

        if(i == rows-1){
            return matrix[i][j];
        }

        if(visited[i][j]){
            return dp[i][j];
        }

        int down = solve(i+1, j, rows, cols, matrix, dp, visited);
        int rightdown = solve(i+1, j+1, rows, cols, matrix, dp, visited);
        int leftdown = solve(i+1, j-1, rows, cols, matrix, dp, visited);

        visited[i][j] = true;
        return dp[i][j] = matrix[i][j] + Math.min(down, Math.min(rightdown, leftdown));
    }

}