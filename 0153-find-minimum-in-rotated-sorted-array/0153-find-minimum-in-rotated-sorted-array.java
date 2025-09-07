class Solution {
    public int findMin(int[] nums) {

        int n = nums.length;

        int l = 0,h = n-1;
        int ans = Integer.MAX_VALUE;

        while(l<=h){

            int m = l+(h-l)/2;

            if( nums[l]<=nums[h]){
                ans = Math.min(ans,nums[l]);
                break;
            }

            if(nums[l]<=nums[m]){
                ans = Math.min(ans,nums[l]);
                l = m+1;
            }else{
                ans = Math.min(ans,nums[m]);
                h = m-1;
            }
        }
        return ans;
        
    }
}