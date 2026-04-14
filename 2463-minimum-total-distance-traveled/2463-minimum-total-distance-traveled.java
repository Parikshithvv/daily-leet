class Solution {
    long[][] dp;

    public long solve(int i, int j, List<Long> pos, List<Long> robot) {
        if (j >= robot.size()) return 0;
        if (i >= pos.size()) return (long)1e15;

        if (dp[i][j] != -1) return dp[i][j];

        long take = Math.abs(robot.get(j) - pos.get(i)) 
                    + solve(i + 1, j + 1, pos, robot);

        long skip = solve(i + 1, j, pos, robot);

        return dp[i][j] = Math.min(take, skip);
    }

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {

        Arrays.sort(factory, (a, b) -> a[0] - b[0]);

        List<Long> robo = new ArrayList<>();
        for (int r : robot) robo.add((long) r);
        Collections.sort(robo);

        List<Long> pos = new ArrayList<>();

        for (int[] f : factory) {
            int location = f[0];
            int limit = f[1];

            for (int j = 0; j < limit; j++) {
                pos.add((long) location);
            }
        }

        dp = new long[pos.size() + 1][robot.size() + 1];
        for (long[] row : dp) Arrays.fill(row, -1);

        return solve(0, 0, pos, robo);
    }
}