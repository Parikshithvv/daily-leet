class Solution {
    public boolean canbloom(int[] bloomDay, int m, int k,int day){
        int n = bloomDay.length;
        int flower  =0;
        int bouquet = 0;
        for(int i=0;i<n;i++){
            if(bloomDay[i] <= day){
                flower++;
                if(flower == k){
                    bouquet++;
                    flower = 0;
                    
                }
            }else{
                flower = 0;

            }
        }
        return bouquet >= m;
    }

    public int getmax ( int[] bloomDay){
        int n = bloomDay.length;
        int max = 0;

        for(int i=0;i<n;i++){
            if(bloomDay[i] > max){
                max = bloomDay[i];
            }
        }
        return max;

    }
    public int minDays(int[] bloomDay, int m, int k) {

        int n = bloomDay.length;

        int low = 1,high = getmax(bloomDay);
        int ans = -1;

        while (low <= high){
            int mid = low +(high-low)/2;

            if(canbloom(bloomDay,m,k,mid)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }


        }
        return ans ; 

        
        
    }
}