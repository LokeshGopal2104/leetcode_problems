class Solution {
    public int longestPalindromeSubseq(String s) {
        
        int n = s.length();

        int [][] dp = new int[n][n];

        // for(int [] row : dp){
        //     Arrays.fill(row, -1);
        // }

        // return solve(0, n-1, s, dp);

        for(int i = 0; i<n; i++){
            dp[i][i] = 1;
        }

        for(int i = n-1; i >=0; i--){
            for(int j = i; j<n; j++){
                if (i == j) continue;

                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = 2 + dp[i+1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }

            }
        }

        return dp[0][n-1];
    }

    public int solve(int i, int j, String s, int [][] dp){
        if(i == j) return 1;

        if(i > j) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        
        if(s.charAt(i) == s.charAt(j)){
            dp[i][j] = 2 + solve(i+1, j-1, s, dp);
        }
        else{
            dp[i][j] = Math.max(solve(i+1, j, s, dp),
                        solve(i, j-1, s, dp)
                    );
        }

        return dp[i][j];
    }

    
}