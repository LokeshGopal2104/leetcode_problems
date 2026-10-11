class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length()-1;
        int j = t.length()-1;

        while(i>=0 || j>=0){

            i = isValid(s, i);
            j = isValid(t, j);


            if(i<0 && j<0){
                return true;
            }
            else if(i<0 || j<0){
                return false;
            }
            else if(s.charAt(i) != t.charAt(j)){
                return false;
            }

            i--;
            j--;
        }
        return true;
    }

    public int isValid(String s, int index){
        int backspace = 0;

        while(index>=0){
            char ch = s.charAt(index);

            if(ch == '#'){
                backspace++;
                index--;
            }else if(backspace>0){
                backspace--;
                index--;
            }else{
                break;
            }
        }
        return index;
    }
}