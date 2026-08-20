class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backtrack(candidates,0,target,0,current,res);
        return res;
    }

    public void backtrack(int [] candidates,int index,int target,int sum,List<Integer> current,List<List<Integer>> res){
        if(sum==target){
            res.add(new ArrayList<>(current));
            return;
        }

        for(int i=index;i<candidates.length;i++){
            if(i>index && candidates[i]==candidates[i-1]) continue;
            if(sum+candidates[i]<=target){
                current.add(candidates[i]);
                sum+=candidates[i];
                backtrack(candidates,i+1,target,sum,current,res);
                sum-=candidates[i];
                current.remove(current.size()-1);
            }
        }
    }
}