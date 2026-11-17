class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum  = 0;
        for(int num : stones){
            sum += num;
        }

        int [][] dp = new int[stones.length][sum+1];

        for(int [] row : dp){
            Arrays.fill(row, -1);
        }
        return solve(stones, 0, 0, sum, dp);
    }

    public int solve(int [] stones,int index,int currentSum, int sum, int[][] dp){
        if(index == stones.length) return Math.abs(sum - 2*currentSum);

        if(dp[index][currentSum] != -1) return dp[index][currentSum];

        int pick = solve(stones, index+1, currentSum+stones[index], sum, dp);
        int notpick = solve(stones, index+1, currentSum, sum, dp);

        return dp[index][currentSum] = Math.min(pick, notpick);
    }
}