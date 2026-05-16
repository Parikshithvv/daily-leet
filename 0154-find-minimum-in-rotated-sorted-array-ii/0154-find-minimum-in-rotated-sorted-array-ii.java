class Solution {
    public int findMin(int[] nums) {
        int n = nums.length - 1;
        int end = nums[n];
        int left = 0, right = n;
        while (left < n && nums[left] == end)
            left++;
        while (left < right) {
            int mid = left + right >> 1;
            if (nums[mid] > end)
                left = mid + 1;
            else
                right = mid;
        }
        return nums[left];
    }
}