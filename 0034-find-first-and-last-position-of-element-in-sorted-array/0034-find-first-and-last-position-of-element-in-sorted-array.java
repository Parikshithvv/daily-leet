class Solution {
    public int[] searchRange(int[] nums, int key) {
        int n = nums.length;

        int start = 0;
        int end = n - 1;
        int first = -1, last = -1;

   
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == key) {
                first = mid;
                end = mid - 1; 
            } else if (key < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        
        start = 0;
        end = n - 1;

        //last occurrence
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == key) {
                last = mid;
                start = mid + 1; 
            } else if (key < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return new int[]{first, last};
    }
}
