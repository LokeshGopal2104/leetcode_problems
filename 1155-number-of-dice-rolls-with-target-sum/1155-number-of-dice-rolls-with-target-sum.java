class Solution {
    static final int MOD = 1_000_000_007;
    public int numRollsToTarget(int n, int k, int target) {
        int [][] dp = new int[n+1][target+1];

        for(int [] row : dp){
           
                Arrays.fill(row, -1);
        
        }
        return solve(n, k, target, dp);
    }

    public int solve(int dice, int k, int remainingSum, int [][] dp){
        if(dice == 0) {
            return remainingSum == 0 ? 1 : 0;
        }

        if(dice == 0 || remainingSum < 0) return 0;

        if(dp[dice][remainingSum]!= -1) return dp[dice][remainingSum];
        long ways = 0;
        for(int i = 1; i<=k; i++){
            
            ways = (ways + solve(dice-1, k, remainingSum-i, dp)) % MOD;
        }

        return  dp[dice][remainingSum] = (int) ways;
    }
}