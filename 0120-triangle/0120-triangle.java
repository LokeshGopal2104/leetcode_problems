class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();
        Integer [][] dp = new Integer[n][n];


        return solve(0, 0, triangle, dp);
    }

    public int solve(int row, int col, List<List<Integer>> triangle,  Integer [][] dp){

        if(row == triangle.size()-1){
            return triangle.get(row).get(col);
        }


        if(dp[row][col] != null){
            return dp[row][col];
        }

        int down = solve(row+1, col, triangle, dp);

        int downRight = solve(row+1, col+1, triangle, dp);

        return dp[row][col] = triangle.get(row).get(col) + Math.min(
            down, downRight
        );
    }
}