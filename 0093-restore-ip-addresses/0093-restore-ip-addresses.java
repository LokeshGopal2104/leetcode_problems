class Solution {
    public List<String> restoreIpAddresses(String s) {
        List< String > res = new ArrayList<>();
        List< String > parts = new ArrayList<>();

        backtrack(s ,0 ,parts ,res );
        
        return res;

    }

    public void backtrack( String s, int index , List< String > parts, List< String > res){

        if (parts.size() == 4) {
            if (index == s.length()) {
                res.add(String.join(".", parts));
            }
            return;
        }

        int remainingDigits = s.length() - index;
        int remainingParts = 4 - parts.size();

        for(int len = 1; len <= 3; len++){

            if(index + len > s.length()){
                break;
            }

            String part = s.substring(index , index + len);

            if( part.length() > 1 && part.charAt(0) == '0' ){
                break;
            }

            if( Integer.parseInt(part)>255 ){
                break;
            }

            parts.add(part);

            backtrack(
                s,
                index+len,
                parts,
                res
            );

            parts.remove( parts.size()-1 );
        }
    }
}