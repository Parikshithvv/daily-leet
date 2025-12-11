class Solution {

    private void findCombinations(int ind, int[] arr, int target, 
                                  List<List<Integer>> ans, List<Integer> temp) {
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        if (ind == arr.length || target < 0) return;

        temp.add(arr[ind]);
        findCombinations(ind, arr, target - arr[ind], ans, temp);
        temp.remove(temp.size() - 1);
        findCombinations(ind + 1, arr, target, ans, temp);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        findCombinations(0, candidates, target, ans, temp);
        return ans;
    }
}
