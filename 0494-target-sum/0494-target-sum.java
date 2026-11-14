class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        int sum = 0;
        for(int num : nums){
            sum += num;
        }

        if (Math.abs(target) > sum) return 0;

        int [][] dp = new int[nums.length][2*sum+1]; 

        for(int [] row : dp){
            Arrays.fill(row, -1);
        }
        return solve(nums, 0, 0, target, dp, sum); 
    }

    public int solve(int [] nums, int index, int currentSum, int target, int[][] dp, int sum){
        if (currentSum == target && index == nums.length){
            return 1;
        }
        if(index >= nums.length) return 0;

        int dpIndex = currentSum + sum;

        if(dp[index][dpIndex] != -1) return dp[index][dpIndex];
        
        int pos = solve(nums, index+1, currentSum+nums[index], target, dp, sum);
        int neg = solve(nums, index+1, currentSum-nums[index], target, dp, sum);

        return dp[index][dpIndex] = pos + neg;
    }
}