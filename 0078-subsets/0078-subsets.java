class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        int n = nums.length;

        solve(nums, n, 0, res, curr);

        return res;
    }

    public void solve(int [] nums, int n, int start, List<List<Integer>> res, List<Integer> curr){
        // if(i == n){
        //     res.add(new ArrayList<>(curr));
        //     return;
        // }

        // curr.add(nums[i]);

        // solve(nums, n, i+1, res, curr);

        // curr.remove(curr.size()-1);

        // solve(nums, n, i+1, res, curr);

        res.add(new ArrayList<>(curr));

        for(int i = start; i < n; i++){
                curr.add(nums[i]);

                solve(nums, n, i+1, res, curr);

                curr.remove(curr.size()-1);
        }
    }
}