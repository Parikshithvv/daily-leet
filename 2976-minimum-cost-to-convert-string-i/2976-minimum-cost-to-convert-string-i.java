import java.util.*;

class Solution {

    void FW(long[][] arr, int[] cost, char[] original, char[] changed) {
        int n = original.length;

       
        for (int i = 0; i < n; i++) {
            int a = original[i] - 'a';
            int b = changed[i] - 'a';
            arr[a][b] = Math.min(arr[a][b], cost[i]);
        }

        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (arr[i][k] != 10000000 && arr[k][j] != 10000000) {
                        arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                    }
                }
            }
        }
    }

    public long minimumCost(
            String source,
            String target,
            char[] original,
            char[] changed,
            int[] cost
    ) {

        long[][] arr = new long[26][26];

        
        for (int i = 0; i < 26; i++) {
            Arrays.fill(arr[i], 10000000);
        }

        FW(arr, cost, original, changed);

        long ans = 0;
        int n = source.length();

        for (int i = 0; i < n; i++) {
            int s = source.charAt(i) - 'a';
            int t = target.charAt(i) - 'a';

            if (s == t) continue;

            if (arr[s][t] == 10000000) return -1;
            ans += arr[s][t];
        }

        return ans;
    }
}
