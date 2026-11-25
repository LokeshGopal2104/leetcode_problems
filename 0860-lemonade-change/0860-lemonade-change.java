class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n = bills.length;
        int five = 0;
        int tens = 0;
        for(int i =0;i<n ; i++){
            if(bills[i] == 5){
                five++;
            }else if(bills[i] == 10){
                if(five == 0) return false;
                tens++;
                five--;
            }else{
                if(tens > 0 && five >0){
                    tens--;
                    five--;
                }
                else if(five>=3){
                    five-=3;
                }
                else{
                    return false;
                }
                
            }
        }

        

        return true;
    }
}