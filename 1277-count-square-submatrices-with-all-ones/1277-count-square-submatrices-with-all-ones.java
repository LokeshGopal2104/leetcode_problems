class Solution {
    public int countSquares(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dp = new int[rows][cols];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int sum = 0;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                dp[i][j] = solve(i, j, matrix, dp);

                if(dp[i][j]>=1){
                    sum += dp[i][j];
                }
            }
        }

        return sum;
    }

    public int solve(int row, int col,
                     int [][] matrix, int[][] dp) {

        // Out of bounds
        if (row < 0 || col < 0) {
            return 0;
        }

        // Memoization check
        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        // Current cell contains zero
        if (matrix[row][col] == 0) {
            return dp[row][col] = 0;
        }

        // First row or first column
        if (row == 0 || col == 0) {
            return dp[row][col] = 1;
        }

        // Recursive dependencies
        int up = solve(row - 1, col, matrix, dp);

        int left = solve(row, col - 1, matrix, dp);

        int diagonal = solve(row - 1, col - 1, matrix, dp);

        // Store and return result
        return dp[row][col] = 1 + Math.min(
            up,
            Math.min(left, diagonal)
        );
    }

}