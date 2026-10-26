class Solution {
    public long mostPoints(int[][] questions) {

        long [] dp = new long[questions.length+1];
        Arrays.fill(dp, -1);

        return solve(questions, 0, dp);

    }

    public long solve(int [][] questions, int index, long [] dp){
        if(index>=questions.length){
            return 0;
        }

        if(dp[index] != -1) return dp[index];

        long skip = solve(questions, index+1, dp);
        long solved  = questions[index][0] +  solve(questions,index+questions[index][1]+1, dp); 

        dp[index] = Math.max(skip, solved);

        return dp[index];
    }
}