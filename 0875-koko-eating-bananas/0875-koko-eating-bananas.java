class Solution {
    public long canEat(int[] piles, int mid) {
        long total = 0;
        for (int i = 0; i < piles.length; i++) {
            total += (long) Math.ceil((double) piles[i] / mid);
        }
        return total;
    }
    public int getMax(int[] piles) {
        int max = 0;
        for (int i = 0; i < piles.length; i++) {
            if (piles[i] > max) {
                max = piles[i];
            }
        }
        return max;
    }
    public int minEatingSpeed(int[] piles, int h) {

        int low = 1;
        int high = getMax(piles);  
        int ans = high;            

        while (low <= high) {
            int mid = low + (high - low) / 2;      
            long totalHours = canEat(piles, mid);    

            if (totalHours <= h) {
                ans = mid;        
                high = mid - 1;  
            } else {
                low = mid + 1;   
            }
        }

        return ans;
    }
}