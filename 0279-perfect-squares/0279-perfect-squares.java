class Solution {
    public int numSquares(int n) {

        int range = (int) Math.sqrt(n);

        int [][] dp = new int [range+1][n+1];
        for(int [] row : dp){
            Arrays.fill(row, -1);
        }
        return solve(1, n, dp, range);

    }
    public int solve(int index, int n, int[][] dp, int range){

        
        if(n == 0) return 0;

        if(index > range || n < 0) return 1000000;
        

        if(dp[index][n] != -1) return dp[index][n];

        
        int pick = 1 + solve(index, n-index*index, dp, range);
        
        

        int notpick = solve(index+1, n, dp, range);

        dp[index][n] = Math.min(pick, notpick);

        return dp[index][n];
    }
}