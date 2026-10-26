class Solution {
    public int numDecodings(String s) {
        int [] dp = new int[s.length()+1];
        Arrays.fill(dp, -1);
        return solve(0,s, dp);
    }

    public int solve(int index, String s, int [] dp){
        if(index>= s.length()) return 1;

        if(s.charAt(index) == '0') return 0;
        
        if(dp[index] != -1) return dp[index];

        int ways = solve(index+1, s, dp);

       if(index + 1 < s.length()){
            int num = Integer.parseInt(s.substring(index, index+2));

            if(num >= 10 && num <= 26){
                ways += solve(index+2, s, dp);
            }
       }

       dp[index] = ways;

       return dp[index];
    }
}