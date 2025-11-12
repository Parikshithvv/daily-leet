class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int countOnes = 0;
        for (int num : nums)
            if (num == 1) countOnes++;    
        if (countOnes > 0) return n - countOnes;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int g = nums[i];
            for (int j = i; j < n; j++) {
                g = gcd(g, nums[j]);
                if (g == 1) {
                    minLen = Math.min(minLen, j - i + 1);
                    break;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? -1 : (minLen - 1) + (n - 1);
    }
    private int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
