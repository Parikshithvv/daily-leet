class Solution {
    public int largestAltitude(int[] gain) {
        int alti = 0, max = 0;
        for (int x : gain) {
            alti += x;
            max = Math.max(max, alti);
        }
        return max;
    }
}