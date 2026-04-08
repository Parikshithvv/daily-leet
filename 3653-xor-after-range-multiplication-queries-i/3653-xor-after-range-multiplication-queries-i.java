class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        final int MOD = 1_000_000_007;
        for (int[] q : queries) {
            int l = q[0], r = q[1], k = q[2], v = q[3];
            for (int idx = l; idx <= r; idx += k) {
                nums[idx] = (int)(1L * nums[idx] * v % MOD);
            }
        }
        int ans = 0;
        for (int x : nums) ans ^= x;
        return ans;
    }
}