class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;
        for (int b : batteries) sum += b;

        long left = Arrays.stream(batteries).min().getAsInt();
        long right = sum / n;
        long ans = 0;

        while (left <= right) {
            long mid = (left + right) >> 1;   
            long reserve = 0;

            for (int x : batteries)
                reserve += Math.min(x, mid);

            if (reserve >= mid * n) {
                ans = mid;      
                left = mid + 1;
            } else {
                right = mid - 1; 
            }
        }
        return ans;
    }
}
