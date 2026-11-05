class Solution {
    public int search(int[] nums, int target) {
        return solve(nums, target, 0, nums.length-1);
    }

    public int solve(int [] nums, int target, int low, int high){
        if(low > high){
            return -1;
        }

        int mid = (low + high) / 2;

        if(nums[mid] == target) return mid;

        if(nums[mid] > target){
            high = mid - 1;
        }else{
            low = mid + 1;
        }

        return solve(nums, target, low, high);
    }
}