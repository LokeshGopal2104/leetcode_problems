class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int slots = 0;
        if(flowerbed.length==1 && flowerbed[0]==0){
            return true;
        }
        for(int i=0;i<flowerbed.length;i++){
            if(i==0){
                if(flowerbed[0]==0 && flowerbed[1]==0){
                    slots++;
                    flowerbed[i]=1;
                }
                
            }else if(i==flowerbed.length-1){
                if(flowerbed[i]==0 && flowerbed[i-1]==0){
                    flowerbed[i]=1;
                    slots++;
                }
            }
            else if(flowerbed[i]==0){
                if(flowerbed[i-1]==0 && flowerbed[i+1] == 0){
                    flowerbed[i]=1;
                    slots++;
                }
            }
        }
        return slots>=n ? true : false;
    }
}