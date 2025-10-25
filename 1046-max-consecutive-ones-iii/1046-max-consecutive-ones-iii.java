class Solution{
    public int longestOnes(int[] nums,int k){
        int l=0,zero=0,maxlen=0;
        for(int r=0;r<nums.length;r++){
            if(nums[r]==0)zero++;
            while(zero>k){
                if(nums[l]==0)zero--;
                l++;
            }
            maxlen=Math.max(maxlen,r-l+1);
        }
        return maxlen;
    }
}