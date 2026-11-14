class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int sum = 0;

        for(int val : coins){
            sum += val;
        }

        int [][] dp = new int[n][amount+1];
        for(int [] row : dp){
            Arrays.fill(row, -1);
        }

        int result = solve(coins, 0, amount, dp);

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public int solve(int [] coins, int index, int amount, int [][] dp){
        if(amount == 0){
            return 0;
        }

        if(amount<0)  return Integer.MAX_VALUE;

        if(index == coins.length) return Integer.MAX_VALUE;

        if(dp[index][amount] != -1) return dp[index][amount];

        int pick = Integer.MAX_VALUE;

        int result = solve(coins, index, amount - coins[index], dp);

        if (result != Integer.MAX_VALUE) {
            pick = 1 + result;
        }
        int notPick = solve(coins, index+1, amount, dp);
        
        return dp[index][amount] = Math.min(pick, notPick);
    }
}