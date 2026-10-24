class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;

        for(int num : nums){
            max = Math.max(max, num);
        }

        int [] dp = new int[max+1];

        Arrays.fill(dp, -1);

        int [] points = new int[max+1];

        for(int num : nums){
            points[num] += num;
        }

        return solve(max,dp,points);
    }


    public int solve(int x, int [] dp, int [] points){
        if(x == 0) return 0;

        if(x == 1) return points[x];

        if(dp[x] != -1) return dp[x];

        int skip = solve(x-1,dp,points);

        int take = points[x] + solve(x-2,dp,points);

        dp[x] = Math.max(take, skip);

        return dp[x];
    }
}