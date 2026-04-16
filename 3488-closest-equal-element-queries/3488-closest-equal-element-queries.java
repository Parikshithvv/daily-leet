class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        List<Integer> result = new ArrayList<>();
        
        for (int q : queries) {
            List<Integer> indices = map.get(nums[q]);
            
           
            if (indices.size() == 1) {
                result.add(-1);
                continue;
            }
            
            int pos = Collections.binarySearch(indices, q);
            int size = indices.size();
            int minDist = Integer.MAX_VALUE;
            
            int prevIdx = indices.get((pos - 1 + size) % size);
            minDist = Math.min(minDist, Math.min(Math.abs(q - prevIdx), n - Math.abs(q - prevIdx)));
            
            
            int nextIdx = indices.get((pos + 1) % size);
            minDist = Math.min(minDist, Math.min(Math.abs(q - nextIdx), n - Math.abs(q - nextIdx)));
            
            result.add(minDist);
        }
        
        return result;
    }
}