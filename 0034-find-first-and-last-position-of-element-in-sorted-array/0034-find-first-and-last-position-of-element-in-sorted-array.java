class Solution {
    public int[] searchRange(int[] nums, int key) {
        int n = nums.length;

        int low = 0, high = n - 1;
        int first = -1, last = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == key) {
                first = mid;
                high = mid - 1;
            } else if (key < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        low = 0;
        high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == key) {
                last = mid;
                low = mid + 1;
            } else if (key < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return new int[]{first, last};
    }
}