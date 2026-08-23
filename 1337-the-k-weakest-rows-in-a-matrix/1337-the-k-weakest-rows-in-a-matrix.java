class Solution {

    class Pair{

        int index;

        int count;

        Pair( int index , int count){

            this.index = index;

            this.count = count;
        }
    }
    public int[] kWeakestRows(int[][] mat, int k) {

        PriorityQueue<Pair> minHeap = new PriorityQueue<>(

            ( a, b) -> {

                if(a.count != b.count){

                    return Integer.compare(b.count, a.count);

                }

                return Integer.compare(b.index, a.index);

            }

        );

        for ( int i = 0; i < mat.length; i++){

            int count = 0;

            for(int soldier : mat[i]){

                if( soldier == 1 ) count++;

            }

            minHeap.offer(new Pair( i, count ));

            if( minHeap.size() > k ){

                minHeap.poll();

            }

        }

        int [] res = new int[k];

        for( int i = k-1; i >= 0; i--){

            res[i] = minHeap.poll().index;

        }

        return res;


    }
}