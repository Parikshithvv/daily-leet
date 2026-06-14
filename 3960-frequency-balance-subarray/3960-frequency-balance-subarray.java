class Solution {
    public int getLength(int[] a) {
        int n = a.length, res = 1;
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> counts = new HashMap<>();
            int[] fq = new int[n + 1];
            int maxF = 0, maxCount = 0;
            
            for (int j = i; j < n; j++) {
                int old = counts.getOrDefault(a[j], 0);
                if (old > 0) fq[old]--;
                
                int curr = old + 1;
                counts.put(a[j], curr);
                fq[curr]++;
                
                if (curr > maxF) {
                    maxF = curr;
                    maxCount = 1;
                } else if (curr == maxF) {
                    maxCount++;
                }
                
                int unique = counts.size();
                if (unique == 1 || (maxF % 2 == 0 && maxCount < unique && fq[maxF / 2] == unique - maxCount)) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }
}