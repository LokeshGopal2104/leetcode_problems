class Solution {
    public int minInsertions(String s) {
        int n = s.length();

        int [][] dp = new int[n][n];

        for(int i=0; i<n ;i++){
            dp[i][i] = 1;
        }

        for(int i = n-1; i>=0; i--){
            for(int j = i; j<n; j++){
                if(i==j) continue;

                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = 2 + dp[i+1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }

        return n - dp[0][n-1];
    }
}