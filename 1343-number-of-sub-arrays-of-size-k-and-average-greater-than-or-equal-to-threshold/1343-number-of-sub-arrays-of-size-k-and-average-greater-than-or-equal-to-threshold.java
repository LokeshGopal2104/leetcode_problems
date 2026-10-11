class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int subs = 0;
        int windowSum = 0;

        for(int i=0;i<k;i++){
            windowSum+=arr[i];
        }

        if((windowSum/k)>=threshold){
            subs++;
        }

        for(int i=k;i<arr.length;i++){
            windowSum = windowSum - arr[i-k] + arr[i];

            if((windowSum/k)>=threshold){
                subs++;
            }

        }

        return subs;
    }
}