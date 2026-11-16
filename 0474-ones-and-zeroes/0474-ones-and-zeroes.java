class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int [][][] dp = new int[strs.length][m+1][n+1];

        for(int [][] matrix : dp){
            for(int [] row : matrix){
                Arrays.fill(row, -1);
            }
            
        }

        return solve(strs, 0, m, n, dp);
    }

    public int solve(String [] strs, int index, int m, int n, int[][][] dp){
        

        if(index == strs.length) return 0;


        if(dp[index][m][n]  != -1) return dp[index][m][n];

        int zeroes = count(strs[index]);
        int ones = strs[index].length() - zeroes;

        int pick = 0;
        if (zeroes <= m && ones <= n) {
            pick = 1 + solve(strs, index + 1,
                             m - zeroes, n - ones, dp);
        }

        int notPick = solve(strs, index+1, m, n, dp);

        dp[index][m][n] = Math.max(pick, notPick);

        return dp[index][m][n];
    }

    public int count(String str){
        int zero = 0;

        for(char ch : str.toCharArray()){
            if(ch == '0') zero++;
        }
        return zero;
    }
}