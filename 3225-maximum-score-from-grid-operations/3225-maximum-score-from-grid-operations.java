class Solution {
    public long maximumScore(int[][] grid) {
        int size = grid.length;
        if (size == 1) return 0L;

        long[][] prefixSum = new long[size][size + 1];

        for (int col = 0; col < size; col++) {
            for (int row = 0; row < size; row++) {
                prefixSum[col][row + 1] = prefixSum[col][row] + grid[row][col];
            }
        }

        final long NEGATIVE = -(1L << 60);

        long[][] dp = new long[size + 1][size + 1];

        for (int prev = 0; prev <= size; prev++) {
            for (int curr = 0; curr <= size; curr++) {
                dp[prev][curr] = Math.max(0L, prefixSum[0][curr] - prefixSum[0][prev]);
            }
        }

        for (int col = 1; col < size; col++) {

            long[][] nextDp = new long[size + 1][size + 1];

            for (int i = 0; i <= size; i++) {
                for (int j = 0; j <= size; j++) {
                    nextDp[i][j] = NEGATIVE;
                }
            }

            for (int middle = 0; middle <= size; middle++) {

                long[] gain = new long[size + 1];

                for (int x = 0; x <= size; x++) {
                    gain[x] = Math.max(0L, prefixSum[col][x] - prefixSum[col][middle]);
                }

                long[] bestPrefix = new long[size + 1];
                bestPrefix[0] = dp[0][middle];

                for (int left = 1; left <= size; left++) {
                    bestPrefix[left] = Math.max(bestPrefix[left - 1], dp[left][middle]);
                }

                long[] bestSuffix = new long[size + 2];

                for (int i = 0; i <= size + 1; i++) {
                    bestSuffix[i] = NEGATIVE;
                }

                bestSuffix[size] = dp[size][middle] + gain[size];

                for (int left = size - 1; left >= 0; left--) {
                    bestSuffix[left] = Math.max(bestSuffix[left + 1], dp[left][middle] + gain[left]);
                }

                int maxNext = (col == size - 1 ? 0 : size);

                for (int next = 0; next <= maxNext; next++) {

                    long bestValue = NEGATIVE;

                    if (bestPrefix[next] != NEGATIVE) {
                        bestValue = Math.max(bestValue, bestPrefix[next] + gain[next]);
                    }

                    if (bestSuffix[next + 1] != NEGATIVE) {
                        bestValue = Math.max(bestValue, bestSuffix[next + 1]);
                    }

                    nextDp[middle][next] = Math.max(nextDp[middle][next], bestValue);
                }
            }

            dp = nextDp;
        }

        long answer = 0;

        for (int i = 0; i <= size; i++) {
            for (int j = 0; j <= size; j++) {
                answer = Math.max(answer, dp[i][j]);
            }
        }

        return answer;
    }
}