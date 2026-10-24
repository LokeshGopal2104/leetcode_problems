class Solution {
    public int rob(int[] nums) {
        int [] dp = new int[nums.length+1];

        Arrays.fill(dp,-1);
        int n = nums.length;
        int max = 0;
        return solve(nums,0,dp);
        
    }

    public int solve(int [] nums, int index, int [] dp){
        if(index>=nums.length){
            return 0;
        }
        if(dp[index]!= -1)return dp[index];



        dp[index] = Math.max(nums[index]+solve(nums,index+2,dp),solve(nums,index+1,dp));

        return dp[index];
    }
}