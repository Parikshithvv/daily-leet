class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int count = 0;

        for (int start = 0; start < n; start++) {
            if (nums[start] == 0) {
                if (simulate(nums.clone(), start, 1)) count++;           
                if (simulate(nums.clone(), start, -1)) count++;
            }
        }

        return count;
    }

    private boolean simulate(int[] nums, int curr, int dir) {
        int n = nums.length;

        while (curr >= 0 && curr < n) {
            if (nums[curr] == 0) {
                curr += dir;  
            } else {
                nums[curr]--; 
                dir = -dir;   
                curr += dir;
            }
        }
        for (int num : nums) {
            if (num != 0) return false;
        }
        return true;
    }
}
