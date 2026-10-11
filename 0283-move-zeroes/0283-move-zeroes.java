class Solution {
    public void moveZeroes(int[] nums) {
        int index = -1;

        for(int i = 0;i<nums.length;i++){
            if(nums[i] == 0){
                index = i;
                break;
            }
        }

        if(index == -1){
            return;
        }

        for(int i = index+1;i<nums.length;i++){
            if(nums[i]!=0){
                int temp = nums[index];
                nums[index++] = nums[i];
                nums[i] = temp;
            }

        }

    }
}