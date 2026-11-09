class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> current = new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();

        solve(1, k, n, current, result);

        return result;
    }

    public void solve(int index, int k, int n, List<Integer> current, List<List<Integer>> result){

        if(n == 0 && current.size() == k){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = index; i < 10; i++){

            if(i > n){
                break;
            }

            current.add(i);

            solve(i+1, k, n-i, current, result);

            current.remove(current.size()-1);
        }

    }
}