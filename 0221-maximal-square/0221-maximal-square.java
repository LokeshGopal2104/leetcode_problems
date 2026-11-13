class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int [][] dp = new int[rows][cols];

        for(int [] row : dp){
            Arrays.fill(row, -1);
        }

        int maxi = 0;

        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                dp[i][j] = solve(i, j, matrix, dp);
                maxi = Math.max(dp[i][j], maxi);
            }
        }

        return maxi*maxi;
    }

    public int solve(int row, int col, char [][] matrix, int [][] dp){
        if(row<0 || col<0){
            return 0;
        }

        if(dp[row][col] != -1) return dp[row][col];

        if(matrix[row][col] == '0'){
            return 0;
        }

        if(row == 0 || col == 0){
            return 1;
        }
        

        int up = solve(row-1, col, matrix, dp);
        int left = solve(row,col-1, matrix, dp);
        int diag = solve(row-1, col-1, matrix, dp);

        return dp[row][col] = 1 + Math.min(
            up,
            Math.min(left, diag)
        );
    }
}