class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> curr = new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();

        int n = nums.length;
        
        Arrays.sort(nums);

        solve(nums, n, 0, curr, res);

        return res;
    }

    public void solve(
        int [] nums,
        int n,
        int start,
        List<Integer> curr,
        List<List<Integer>> res
    ){
        
        res.add(new ArrayList<>(curr));
            
        for(int i = start; i < n; i++){

            if(i>start && nums[i] == nums[i-1]){
                continue;
            }

            curr.add(nums[i]);

            solve(nums, n, i+1, curr, res);

            curr.remove(curr.size()-1);
        }
        

        
    }
}