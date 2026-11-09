class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {

        Set<List<Integer>> set = new HashSet<>();

        List<Integer> current = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        boolean[] used = new boolean[nums.length];

        solve(nums, used, current, set, result);

        return result;
    }

    public void solve(int[] nums, boolean[] used,
                      List<Integer> current,
                      Set<List<Integer>> set,
                      List<List<Integer>> result) {

        if (current.size() == nums.length) {

            if (!set.contains(current)) {
                result.add(new ArrayList<>(current));
                set.add(new ArrayList<>(current));
            }

            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (used[i]) {
                continue;
            }

            current.add(nums[i]);
            used[i] = true;

            solve(nums, used, current, set, result);

            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}