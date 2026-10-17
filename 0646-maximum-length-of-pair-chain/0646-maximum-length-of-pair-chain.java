class Solution {
    public int findLongestChain(int[][] pairs) {
        if(pairs.length<=1){
            return pairs.length;
        }
        Arrays.sort(pairs,(a,b)->Integer.compare(a[1],b[1]));
        
     
        int longest = 0;
        
        int chain = 1;
        int end = pairs[0][1];
        for(int i=1;i<pairs.length;i++){
            if(end<pairs[i][0]){
                chain++;
                end = pairs[i][1];
            }
            
        }
        return chain;
    }
}