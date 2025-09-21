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



//example
Input:

nums = [1,2,5,9], threshold = 6


getmax(nums) = 9

Search space = [1..9]

Binary Search Steps:

mid = 5 → sum = ceil(1/5)+ceil(2/5)+ceil(5/5)+ceil(9/5) = 1+1+1+2 = 5 ≤ 6 ✅ (try smaller divisor)

high = 4

mid = 2 → sum = ceil(1/2)+ceil(2/2)+ceil(5/2)+ceil(9/2) = 1+1+3+5 = 10 > 6 ❌ (too small divisor)

low = 3

mid = 3 → sum = 1+1+2+3 = 7 > 6 ❌

low = 4

mid = 4 → sum = 1+1+2+3 = 7 > 6 ❌

low = 5 → high = 4 → loop ends

Answer = low = 5.

✅ Smallest divisor = 5
