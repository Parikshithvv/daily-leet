class Solution {
    public int numberOfSubarrays(int[] nums, int goal) {
        return atMost(nums,goal)-atMost(nums,goal-1);
    }

    private int atMost(int[] nums,int goal){
        if(goal<0)return 0;
        int l=0,sum=0,cnt=0;
        for(int r=0;r<nums.length;r++){
            sum+=(nums[r]%2);
            while(sum>goal){
                sum-=(nums[l]%2);
                l++;
            }
            cnt+=(r-l+1);
        }
        return cnt;
    }
}

        