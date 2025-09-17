class Solution {
    public long caneat(int[] piles, int mid){
         int n = piles.length;

        long total = 0;

        for(int i=0;i<n;i++){
            total += (long) Math.ceil((double) piles[i] / mid);
        }
        return total;

    }

    public int getmax(int[] piles){
        int baigan = 0;
         int n = piles.length;

        for(int i=0;i<n;i++){
            if(piles[i]>baigan){
                baigan = piles[i];
            }
        }

        return baigan;
    }
    public int minEatingSpeed(int[] piles, int h) {

        int n = piles.length;

        int low = 1,high = getmax(piles);
        int ans =high;
         
        while(low <= high){
            int mid = low+(high-low)/2;
            long totalhrs = caneat(piles,mid);

            if(totalhrs<=h){
                ans = mid;
                high = mid-1;

            }else{
                low = mid+1;
            }


        }

        return ans;

        
    }
}