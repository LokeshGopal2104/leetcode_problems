class Solution {

    class Char{
        char s;
        int n;

        Char(char s, int n){
            this.s = s;
            this.n = n;
        }
    }

    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();

        PriorityQueue<Char> maxHeap = new PriorityQueue<>(
            (char1,char2) -> {
                if(char1.n!=char2.n){
                    return Integer.compare(char2.n,char1.n);
                }
                return Character.compare(char2.s, char1.s);
            }
        );

        for(int i =0;i<s.length();i++){
            map.put(
                s.charAt(i),
                map.getOrDefault(s.charAt(i),0)+1
            );
        }

        for(Map.Entry<Character,Integer> entry : map.entrySet()){

            maxHeap.offer(
                new Char(entry.getKey(),entry.getValue())
            );

        }

        StringBuilder sb = new StringBuilder();

        while(!maxHeap.isEmpty()){
            Char ch = maxHeap.poll();
            sb.append(String.valueOf(ch.s).repeat(ch.n));
        }

        return sb.toString();

    }
}