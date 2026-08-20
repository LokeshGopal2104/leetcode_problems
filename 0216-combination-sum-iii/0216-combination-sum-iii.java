class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        
        backtrack(k,n,1,0,current,res);

        return res;
    }

    public void backtrack(int k,int n,int index,int sum,List<Integer> current,List<List<Integer>> res){
        if(sum==n && current.size()==k){
            res.add(new ArrayList<>(current));
            return;
        }

        for(int i=index;i<=9;i++){
            if(sum+i<=n){
                sum+=i;
                current.add(i);
                backtrack(k,n,i+1,sum,current,res);
                sum-=i;
                current.remove(current.size()-1);
            }
        }
    }
}