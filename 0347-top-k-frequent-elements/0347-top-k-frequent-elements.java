class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num : nums ){

            map.put(
                num,
                map.getOrDefault(num,0)+1
            );

        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
            (a,b) -> Integer.compare(
                a.getValue(),
                b.getValue()
            )
        );
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){

            minHeap.offer(entry);

            if(minHeap.size()>k){
                minHeap.poll();
            }

        } 

        int [] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = minHeap.poll().getKey();
        }

        return res;
    }
}