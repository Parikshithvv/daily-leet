class Solution {
    public boolean canWePlace(int[] stalls, int dist, int cows) {
        int n = stalls.length;
        int cntCows = 1;       
        int last = stalls[0];   

        for (int i = 1; i < n; i++) {
            if (stalls[i] - last >= dist) {
                cntCows++;
                last = stalls[i];
            }
            if (cntCows >= cows) return true;
        }
        return false;
    }

    public int maxDistance(int[] position, int m) {
        int n = position.length;
        Arrays.sort(position); 

        int low = 1, high = position[n - 1] - position[0];
        int ans = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (canWePlace(position, mid, m)) {
                ans = mid;       
                low = mid + 1;
            } else {
                high = mid - 1; 
            }
        }
        return ans;
    }
}
