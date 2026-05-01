class Solution {
    public int maxRotateFunction(int[] nums) {
        int sum = 0;
        int a = 0;
        int n = nums.length;

        for(int i=0;i<n;i++){
            sum = sum+nums[i];
            a = a+(i*nums[i]);
        }
        int max = a;
        for(int i=1;i<n;i++){
            a += sum - n * nums[n-i];
            max = Math.max(max,a);
        }
        return max;
        
    }
}