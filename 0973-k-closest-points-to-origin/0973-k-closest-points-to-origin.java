class Solution {

    class Point{
        int [] arr;
        double dis;

        Point(int [] arr, double dis){
            this.arr = arr;

            this.dis = dis;
        }
    }
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<Point> maxHeap = new PriorityQueue<>(
                                            (a, b) -> Double.compare(b.dis, a.dis)
                                        );

        for( int [] point : points ){
            
            int x = Math.abs(
                        point[0]*point[0]
                    );

            int y = Math.abs(
                        point[1]*point[1]
                    );
            maxHeap.offer(
                new Point(
                    point,
                    Math.sqrt(x+y)
                )
            );
                
            if(maxHeap.size()>k){
                maxHeap.poll();
            }

        }

        int [][] res = new int[k][2];

        for(int i = 0; i < k; i++){
            res[i] = maxHeap.poll().arr;
        }

        return res;

    }
}