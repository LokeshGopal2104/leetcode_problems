class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int mini = Integer.MAX_VALUE;
        
        for(int num : prices){
            mini = Math.min(mini, num);

            profit = Math.max(profit, num-mini);
        }

        return profit;
    }
}