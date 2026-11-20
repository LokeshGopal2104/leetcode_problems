class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        int [][] dp = new int[n][m];

        for(int [] row : dp){
            Arrays.fill(row, -1);
        }    

        return solve(0, 0, s, t, dp);
    }

    public int solve(int i, int j, String s, String t, int[][] dp){
        if(i>=s.length() && j<t.length()){
            return 0;
        }

        if(j>=t.length()){
            return 1;
        }


        if(dp[i][j] != -1) return dp[i][j];

        int pick = 0;
        if(s.charAt(i) == t.charAt(j)){
            pick = solve(i+1, j+1, s, t, dp);
        }

        int notpick = solve(i+1, j, s, t, dp);

        return dp[i][j] = pick + notpick;
    }


}