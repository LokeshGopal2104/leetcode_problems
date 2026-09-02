import java.util.*;

class Solution {

    class Word {
        String s;
        int n;

        Word(String s, int n) {
            this.s = s;
            this.n = n;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();

        // Min-heap sorted by frequency (n) ascending. 
        // If frequencies match, sort alphabetically (s) descending to correctly keep top elements.
        PriorityQueue<Word> minHeap = new PriorityQueue<>(
            (w1, w2) -> {
                if (w1.n != w2.n) {
                    return Integer.compare(w1.n, w2.n);
                }
                return w2.s.compareTo(w1.s); 
            }
        );

        // 1. Populate the frequency map
        for (String str : words) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        // 2. Push elements into minHeap and maintain size k
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            minHeap.offer(new Word(entry.getKey(), entry.getValue()));
            if (minHeap.size() > k) {
                minHeap.poll(); // Evict the least frequent element
            }
        }

        // 3. Build the final answer list
        List<String> ans = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            Word w = minHeap.poll();
            ans.add(w.s);
        }

        // 4. Reverse the list because min-heap outputs the smallest of the top-K first
        Collections.reverse(ans);

        return ans;
    }
}
