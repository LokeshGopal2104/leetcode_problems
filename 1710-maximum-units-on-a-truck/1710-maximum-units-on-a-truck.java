class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b)->Integer.compare(b[1],a[1]));
        int boxes = 0;
        int res = 0;
        for(int i=0;i<boxTypes.length;i++){
            if(boxes+boxTypes[i][0]<=truckSize){
                res+= boxTypes[i][0]*boxTypes[i][1];
                boxes+=boxTypes[i][0];
            }else{
                int rem = truckSize-boxes;
                res+=rem*boxTypes[i][1];
                break;
            }
        }
        return res;
    }
}