class Solution {
    private void backtrack(int index, int[] candidates, int target,
                           List<List<Integer>> result, List<Integer> current) {

        if(target == 0){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = index;i<candidates.length;i++){
            if(i>index && candidates[i] == candidates[i-1])
            continue;
            if(candidates[i] > target)
            break;

            current.add(candidates[i]);
            backtrack(i+1,candidates,target-candidates[i],result,current);
            current.remove(current.size()-1);

        }
        
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0,candidates,target,result,new ArrayList<>());
        return result;

    }


}