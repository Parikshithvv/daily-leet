class Solution {
    public boolean stoneGameIX(int[] stones) {
        int s0 = 0;
        int s1 = 0;
        int s2 = 0;

        for (int stone : stones) {
            int rem = stone % 3;
            if (rem == 0) {
                s0++;
            } else if (rem == 1) {
                s1++;
            } else {
                s2++;
            }
        }

        if (s0 % 2 == 0) {
            return s1 > 0 && s2 > 0;
        }

        return Math.abs(s1 - s2) > 2;
    }
}