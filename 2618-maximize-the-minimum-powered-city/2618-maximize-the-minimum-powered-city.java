class Solution {
    public long maxPower(int[] base, int range, long extraStations) {
        int len = base.length;
        long[] totalPower = new long[len];
        long currentSum = 0;

       
        for (int i = 0; i <= Math.min(len - 1, range); i++) {
            currentSum += base[i];
        }

        for (int i = 0; i < len; i++) {
            totalPower[i] = currentSum;
            int leftOut = i - range;
            if (leftOut >= 0) currentSum -= base[leftOut];
            int rightIn = i + range + 1;
            if (rightIn < len) currentSum += base[rightIn];
        }

        long low = 0;
        long high = Arrays.stream(totalPower).max().orElse(0L) + extraStations;
        long answer = 0;

 
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (canAchieve(totalPower, range, extraStations, mid)) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return answer;
    }

    private boolean canAchieve(long[] totalPower, int range, long extraStations, long target) {
        int n = totalPower.length;
        long used = 0;
        long[] increment = new long[n + 1];
        long activeAdd = 0;

        for (int i = 0; i < n; i++) {
            activeAdd += increment[i];
            long current = totalPower[i] + activeAdd;

            if (current < target) {
                long need = target - current;
                used += need;
                if (used > extraStations) return false;

                activeAdd += need;
                int endIdx = Math.min(n, i + 2 * range + 1);
                increment[endIdx] -= need;
            }
        }
        return true;
    }
}
