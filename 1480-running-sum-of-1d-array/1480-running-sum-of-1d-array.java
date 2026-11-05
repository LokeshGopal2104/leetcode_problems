class Solution {
    public int[] runningSum(int[] nums) {
        return solve(nums, 0,0);
    }

    public int[] solve(int [] nums, int sum, int i){
        if(i == nums.length) return nums;

        sum+= nums[i];

        nums[i] = sum;

        return solve(nums, sum, i+1);
    }
}