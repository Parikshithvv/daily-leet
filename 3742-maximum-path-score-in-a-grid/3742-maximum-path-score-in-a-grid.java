class Solution {
    public int maxPathScore(int[][] a, int b) {
        int r = a.length;
        int s = a[0].length;

        int[][][] d = new int[r][s][b + 1];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < s; j++) {
                for (int x = 0; x <= b; x++) {
                    d[i][j][x] = -1;
                }
            }
        }

        d[0][0][0] = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < s; j++) {
                for (int x = 0; x <= b; x++) {
                    if (d[i][j][x] == -1) continue;

                    if (i + 1 < r) {
                        int v = a[i + 1][j];
                        int y = (v == 0 ? 0 : 1);
                        int z = x + y;

                        if (z <= b) {
                            d[i + 1][j][z] = Math.max(d[i + 1][j][z], d[i][j][x] + v);
                        }
                    }

                    if (j + 1 < s) {
                        int v = a[i][j + 1];
                        int y = (v == 0 ? 0 : 1);
                        int z = x + y;

                        if (z <= b) {
                            d[i][j + 1][z] = Math.max(d[i][j + 1][z], d[i][j][x] + v);
                        }
                    }
                }
            }
        }

        int res = -1;
        for (int x = 0; x <= b; x++) {
            res = Math.max(res, d[r - 1][s - 1][x]);
        }

        return res;
    }
}