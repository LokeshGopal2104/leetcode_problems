class Solution {
    public int maxCoins(int[] piles) {
        int n = piles.length;
        int left = 0;
        int right = n-2;

        Arrays.sort(piles);

        int res = 0;

        while(left<right){
            res+=piles[right];

            right-=2;
            left++;
        }

        return res;
    }

  
}