
import java.util.*;

class Solution {

    public int findNumberOfLIS(int[] nums) {

        int n = nums.length;

        int[][][] dp = new int[n + 1][n + 1][2];

        for (int[][] matrix : dp) {
            for (int[] row : matrix) {
                Arrays.fill(row, -1);
            }
        }

        for (int prev = 0; prev <= n; prev++) {
            dp[n][prev][0] = 0;
            dp[n][prev][1] = 1;
        }

        solve(nums, 0, -1, dp);

        return dp[0][0][1];
    }

    public void solve(int[] nums, int index, int prevIndex, int[][][] dp) {

        if (index == nums.length) {
            return;
        }

        if (dp[index][prevIndex + 1][0] != -1) {
            return;
        }

        int pickLength = -1;
        int pickCount = 0;

        int notPickLength;
        int notPickCount;

        // Pick
        if (prevIndex == -1 || nums[index] > nums[prevIndex]) {

            solve(nums, index + 1, index, dp);

            pickLength = 1 + dp[index + 1][index + 1][0];
            pickCount = dp[index + 1][index + 1][1];
        }

        // Not Pick
        solve(nums, index + 1, prevIndex, dp);

        notPickLength = dp[index + 1][prevIndex + 1][0];
        notPickCount = dp[index + 1][prevIndex + 1][1];

        // Compare
        if (pickLength > notPickLength) {

            dp[index][prevIndex + 1][0] = pickLength;
            dp[index][prevIndex + 1][1] = pickCount;

        } else if (notPickLength > pickLength) {

            dp[index][prevIndex + 1][0] = notPickLength;
            dp[index][prevIndex + 1][1] = notPickCount;

        } else {

            dp[index][prevIndex + 1][0] = pickLength;
            dp[index][prevIndex + 1][1] = pickCount + notPickCount;
        }
    }
}
