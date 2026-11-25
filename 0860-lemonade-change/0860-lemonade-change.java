class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n = bills.length;
        boolean [] used = new boolean[n];
        int five = 0;
        int tens = 0;
        for(int i =0;i<n ; i++){
            if(bills[i] == 5){
                used[i] = true;
                five++;
            }else if(bills[i] == 10 && five > 0){
                used[i] = true;
                tens++;
                five--;
            }else {
                if(tens > 0 && five >0){
                    used[i] = true;
                    tens--;
                    five--;
                }
                else if(five>=3){
                    used[i] = true;
                    five-=3;
                }
                
            }
        }

        for(boolean flag : used){
            if(flag == false) return false;
        }

        return true;
    }
}