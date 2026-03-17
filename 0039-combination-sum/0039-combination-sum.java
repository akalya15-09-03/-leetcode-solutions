class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // Passing a new list to avoid side effects
        backtrack(candidates, target, result, new ArrayList<>(), 0);
        return result;
    }

    private void backtrack(int[] candidates, int target, List<List<Integer>> result, List<Integer> temp, int start) {
        if (target == 0) {
            // Found a valid combination; add a copy of the current temp list
            result.add(new ArrayList<>(temp));
            return;
        }
        if (target < 0) {
            return; // Target exceeded; stop this branch
        }

        for (int i = start; i < candidates.length; i++) {
            temp.add(candidates[i]);
            // Reuse the same index 'i' to allow using the same number multiple times
            backtrack(candidates, target - candidates[i], result, temp, i);
            // Remove the last element to backtrack and try the next candidate
            temp.remove(temp.size() - 1);
        }
    }
}
