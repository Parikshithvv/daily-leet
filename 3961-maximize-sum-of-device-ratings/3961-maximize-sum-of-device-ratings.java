class Solution {
    public long maxRatings(int[][] units) {
        int n = units.length;
        if (n == 1) {
            int res = Integer.MAX_VALUE;
            for (int x : units[0]) res = Math.min(res, x);
            return res;
        }
        long total = 0;
        boolean single = true;
        for (int[] row : units) {
            if (row.length == 1) total += row[0];
            else { single = false; break; }
        }
        if (single) return total;
        total = 0;
        int globMin = Integer.MAX_VALUE, minSnd = Integer.MAX_VALUE;
        for (int[] row : units) {
            int m1 = Integer.MAX_VALUE, m2 = Integer.MAX_VALUE;
            for (int x : row) {
                if (x < m1) { m2 = m1; m1 = x; }
                else if (x < m2) m2 = x;
            }
            total += m2;
            globMin = Math.min(globMin, m1);
            minSnd = Math.min(minSnd, m2);
        }
        return (long) globMin + total - minSnd;
    }
}