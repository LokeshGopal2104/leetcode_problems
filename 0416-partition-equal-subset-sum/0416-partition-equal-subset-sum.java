class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }

        if(sum%2 == 1) return false;
        Boolean [][] dp = new Boolean[nums.length][sum/2+1];
        return solve(nums, 0, 0, sum/2, dp);
    }

    public boolean solve(int [] nums, int index , int currentSum, int target, Boolean [][] dp){
        if(currentSum == target){
            return true;
        }
        if(currentSum > target || index >=nums.length){
            return false;
        }

        if(dp[index][currentSum] != null) return dp[index][currentSum];

        return dp[index][currentSum] = solve(nums, index+1, currentSum+nums[index], target, dp) ||
                                       solve(nums, index+1, currentSum, target, dp);  


    }
}