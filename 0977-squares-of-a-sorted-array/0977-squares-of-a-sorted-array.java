class Solution {
    public int[] sortedSquares(int[] nums) {
        int [] result = new int[nums.length];

        int left = 0;
        int right = nums.length-1;
        int position = nums.length-1;

        while(left <= right){

            int leftValue = nums[left];
            int rightValue = nums[right];

            if(Math.abs(leftValue)>Math.abs(rightValue)){
                result[position--] = leftValue*leftValue;
                left++;
            }else{
                result[position--] = rightValue*rightValue;
                right--;
            }

        }
        return result;
    }
}