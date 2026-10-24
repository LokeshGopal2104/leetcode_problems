class Solution {
    public int rob(int[] nums) {
        int [] dp = new int[nums.length+1];

        Arrays.fill(dp,-1);
        int n = nums.length;
        int max = 0;
        for(int i = 0;i<n;i++){
            max = Math.max(max, solve(nums,i,dp));
        }
        return max;
    }

    public int solve(int [] nums, int index, int [] dp){
        if(index>=nums.length){
            return 0;
        }
        if(dp[index]!= -1)return dp[index];



        dp[index] = nums[index] + Math.max(solve(nums,index+2,dp),solve(nums,index+3,dp));

        return dp[index];
    }
}