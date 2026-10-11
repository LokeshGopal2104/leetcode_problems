class Solution {
    public int removeDuplicates(int[] nums) {

        if(nums.length == 0){
            return 0;
        }
        int write = 0;

        for(int read = 1; read<nums.length; read++){
            if(nums[write]!=nums[read]){
                nums[write+1] = nums[read];
                write++;
            }
        }
        return write+1;
    }
}