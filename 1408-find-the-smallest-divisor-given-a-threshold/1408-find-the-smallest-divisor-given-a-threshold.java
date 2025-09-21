class Solution {


    public int sum (int[] nums , int div){
        int sum = 0;
        int n = nums.length;

        for(int i=0;i<n;i++){

           sum += (int) Math.ceil((double) nums[i] / div);
            
        }
        return sum;
    }

    public int getmax(int[] nums){
        int n = nums.length;
        int max =0;

        for(int i=0;i<n;i++){
            if(nums[i] > max){
                max = nums[i];
            }
        }
        return max;
    }



    public int smallestDivisor(int[] nums, int threshold) {

        int low = 1, high = getmax(nums);

        while(low <= high){
            int mid = low+(high-low)/2;

            if(sum(nums,mid) <= threshold){
                high = mid-1;

            }else{
                low = mid+1;
            }
        }
        return low;

        
        
    }
}