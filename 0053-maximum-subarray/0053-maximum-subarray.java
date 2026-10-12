class Solution {
    public int maxSubArray(int[] nums) {
        int left = 0;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int right = 0;right<nums.length;right++){
            sum+=nums[right];
            maxSum = Math.max(maxSum,sum);
            while(left<=right && sum<=0){
                sum-=nums[left];
                left++;
            }

        }
        return maxSum;
    }
}