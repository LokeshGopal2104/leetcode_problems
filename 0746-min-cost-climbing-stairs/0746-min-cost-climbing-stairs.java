class Solution {
    public int minCostClimbingStairs(int[] cost) {

        int n = cost.length;
        // for(int i = 0; i<n;i++){
        //     ans[i] = minCost(i, n, cost,0);
        // }
        int [] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return Math.min(minCost(0, n, cost,dp),minCost(1, n, cost,dp));
        
    }

    public int minCost(int i, int n, int [] cost, int [] dp){
        if(i>=n) return 0;

        if(dp[i] != -1) return dp[i];

        dp[i] = cost[i] + Math.min(minCost(i+1,n,cost,dp), minCost(i+2,n,cost,dp));

        return dp[i];

    }
}