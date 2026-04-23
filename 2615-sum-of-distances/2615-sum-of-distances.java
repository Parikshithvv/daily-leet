class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n];

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        for (List<Integer> list : map.values()) {
            int m = list.size();
            long prefix = 0;
            long total = 0;

            for (int idx : list) total += idx;

            for (int i = 0; i < m; i++) {
                int idx = list.get(i);

                long left = (long) idx * i - prefix;
                long right = (total - prefix - idx) - (long) idx * (m - i - 1);

                ans[idx] = left + right;

                prefix += idx;
            }
        }

        return ans;
    }
}