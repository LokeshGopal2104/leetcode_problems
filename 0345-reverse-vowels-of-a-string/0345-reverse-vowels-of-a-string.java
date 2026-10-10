class Solution {
    public String reverseVowels(String s) {
        HashSet<Character> vowels = new HashSet<>();

        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        int left = 0;
        int right = s.length()-1;

        char [] word = s.toCharArray();

        while(left<right){

            if(vowels.contains(Character.toLowerCase(word[left])) &&
                 vowels.contains(Character.toLowerCase(word[right]))){
                char temp = word[left];
                word[left++] = word[right];
                word[right--] = temp;

            }
            else if(!vowels.contains(Character.toLowerCase(word[left]))){
                left++;
            }else{
                right--;
            }

        }

        return new String(word);
        
    }
}