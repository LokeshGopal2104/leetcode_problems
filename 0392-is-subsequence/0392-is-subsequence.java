class Solution {
    public boolean isSubsequence(String s, String t) {
        int sIndex = 0;
        int tIndex = 0;

        if(s.length() == 0){
            return true;
        }
        while(sIndex<s.length() && tIndex<t.length()){
            if(s.charAt(sIndex) == t.charAt(tIndex)){
                sIndex++;
                tIndex++;
            }else{
                tIndex++;
            }

            if(sIndex == s.length()) return true;
        }
        return false;
    }
}