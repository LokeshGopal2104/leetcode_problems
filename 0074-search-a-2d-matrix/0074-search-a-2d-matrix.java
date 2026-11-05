class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        return solve(matrix, target, 0, rows*cols-1, cols);

    }

    public boolean solve(int [][] matrix, int target, int low, int high, int cols){

        if(low>high) return false;

        int mid = (low + high) / 2;
        if(matrix[mid / cols][mid % cols] == target) return true;

        if(matrix[mid / cols][mid % cols] > target ){
            high = mid - 1;
        }else{
            low = mid + 1;
        }

        return solve(matrix, target, low, high, cols);
    }
}