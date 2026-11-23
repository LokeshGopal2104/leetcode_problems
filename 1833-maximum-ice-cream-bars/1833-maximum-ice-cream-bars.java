class Solution {
    public int maxIceCream(int[] costs, int coins) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int cost : costs){
            pq.offer(cost);
        }

        int res = 0;
        while(!pq.isEmpty() && coins>0){
            int cost = pq.poll();
            if(cost<=coins){
                res++;
                coins -= cost;
            }else{
                break;
            }
        }
        return res;
    }
}