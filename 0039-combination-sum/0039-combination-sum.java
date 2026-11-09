class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> current = new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(candidates);

        solve(candidates, 0, target, current, result);

        return result;
    }

    public void solve(int [] candidates, int index, int target, List<Integer> current, List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<>(current));
            return;
        }


        for(int i = index; i < candidates.length; i++){
            if(candidates[i] > target){
                break;
            }

            current.add(candidates[i]);

            solve(candidates, i, target-candidates[i], current, result);

            current.remove(current.size()-1);
        }
    }
}