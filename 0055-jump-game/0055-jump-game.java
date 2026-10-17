class Solution {
    public boolean canJump(int[] nums) {
        int index = 0;
        for(int i=0;i<nums.length;i++){
            if(i<=index){
                index = Math.max(index,i+nums[i]);
            }else{
                return false;
            }
        }
        return index >= nums.length-1 ? true : false;
    }
}