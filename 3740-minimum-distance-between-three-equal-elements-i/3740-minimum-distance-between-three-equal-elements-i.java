class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;

        Map<Integer,List<Integer>>map = new HashMap<>();
        int min = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
           map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
            List<Integer> list = map.get(nums[i]);
           if (list.size() >= 3) {
                int size = list.size();
                int dist = 2 * (list.get(size - 1) - list.get(size - 3));
                min = Math.min(min, dist);
            }
          
        }
        return min == Integer.MAX_VALUE ? -1 : min;
        
    }
}