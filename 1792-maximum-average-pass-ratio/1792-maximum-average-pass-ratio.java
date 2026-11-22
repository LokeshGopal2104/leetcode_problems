class Solution {

    class ClassInfo{
        int pass;
        int total;
        double improvement;

        ClassInfo(int pass, int total){
            this.pass = pass;
            this.total = total;
            this.improvement = calculateImprovement();
        }

        double calculateImprovement(){
            return (double)(this.total-this.pass)/((double)(this.total)*(this.total+1));
        }
    }
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<ClassInfo> pq = new PriorityQueue<>((a,b) -> (Double.compare(b.improvement, a.improvement)));

        for(int[] cls : classes){
            pq.offer(new ClassInfo(
                cls[0],
                cls[1]
            ));
        }

        for(int i = 0; i<extraStudents; i++){
            ClassInfo cls = pq.poll();

            cls.pass++;
            cls.total++;

            cls.improvement = cls.calculateImprovement(); 

            pq.offer(cls);
        }

        double res = 0;

        while(!pq.isEmpty()){
            ClassInfo cls = pq.poll();

            res += (double) cls.pass/cls.total;
        }

        return res/classes.length;
    }
}