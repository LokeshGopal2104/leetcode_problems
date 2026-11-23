class Solution {
   
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int [] needed = new int[n];

        for(int i=0; i<n; i++){
            needed[i] = capacity[i]-rocks[i];
        }

        Arrays.sort(needed);

        int fullbags = 0;

        for(int i=0; i<n; i++){
            if(needed[i] == 0){
                fullbags++;
            }else if(additionalRocks >= needed[i]){
                additionalRocks-=needed[i];
                fullbags++;
            }else{
                break;
            }
        }

        return fullbags;
    }
}