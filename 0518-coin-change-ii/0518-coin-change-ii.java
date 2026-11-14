class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        int[][] dp = new int[n][amount + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int result = solve(coins, 0, amount, dp);

        return result;
    }
     public int solve(
        int[] coins,
        int index,
        int amount,
        int[][] dp
    ){

        if (amount == 0) {
            return 1;
        }

        if (index == coins.length) {
            return 0;
        }

        if (dp[index][amount] != -1) {
            return dp[index][amount];
        }

        int pick = 0;
        if (coins[index] <= amount){
            pick = solve(
                coins,
                index,
                amount - coins[index],
                dp
            );
        }

        int notPick = solve(
            coins,
            index + 1,
            amount,
            dp
        );

        return dp[index][amount] = pick + notPick;
    }
}