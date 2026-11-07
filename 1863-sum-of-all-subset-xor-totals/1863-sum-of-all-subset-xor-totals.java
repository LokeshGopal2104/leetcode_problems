class Solution {
    public int subsetXORSum(int[] nums) {
        
        return solve(nums, nums.length, 0, 0);

       
    }

    public int solve(
        int [] nums,
        int n,
        int i,
        int currXor
    ){

        int total = currXor;

        for(int j = i; j<n;j++){
            
            currXor ^= nums[j];

            total += solve(nums, n, j+1, currXor);

            currXor ^= nums[j];

        }

        return total;
    }
}