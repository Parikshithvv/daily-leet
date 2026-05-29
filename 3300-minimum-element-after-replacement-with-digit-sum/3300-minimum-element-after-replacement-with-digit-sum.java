class Solution {
    public int minElement(int[] nums) {
        int minResult = Integer.MAX_VALUE;
        
        for (int num : nums) {
            int digitSum = 0;
            int temp = num;
            
            while (temp > 0) {
                digitSum += temp % 10;
                temp = temp / 10;
            }
            
            if (digitSum < minResult) {
                minResult = digitSum;
            }
        }
        
        return minResult;
    }
}