class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        String [] mapping = {
            "","", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        solve(digits, 0, mapping, sb, res);

        return res;
    }

    public void solve(String digits, int index, String [] mapping, StringBuilder sb, List<String> res){


        if(index == digits.length()){
            res.add(sb.toString());
            return;
        }

        String letters = mapping[digits.charAt(index) - '0'];
        for(int i = 0; i < letters.length(); i++){

            sb.append(letters.charAt(i));

            solve(digits, index+1, mapping, sb, res);

            sb.deleteCharAt(sb.length()-1);
        }
    }
}