class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> curr = new ArrayList<>();

        // Arrays.sort(nums);

        solve(nums, nums.length, 0, curr, res);

        return res;

    }

    public void solve(
        int [] nums,
        int n,
        int start,
        List<Integer> curr,
        List<List<Integer>> res
    ){
        if(curr.size()>=2){
            res.add(new ArrayList<>(curr));
        }

        Set<Integer> used = new HashSet<>();

        for(int i = start; i < n; i++){

            if(used.contains(nums[i])) continue;

            used.add(nums[i]);

            if(curr.isEmpty() || nums[i] >= curr.get(curr.size()-1)){

                curr.add(nums[i]);

                solve(nums, n, i+1, curr, res);

                curr.remove(curr.size()-1);
            }
        }
    }
}