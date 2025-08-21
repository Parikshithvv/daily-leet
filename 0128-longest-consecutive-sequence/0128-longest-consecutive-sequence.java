import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int longest = 1;
        Set<Integer> set = new HashSet<>();

        // put all elements into set
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }

        // find the longest sequence
        for (int it : set) {
            // if 'it' is a starting number
            if (!set.contains(it - 1)) {
                int cnt = 1;                //search for previous no 
                int x = it;

                while (set.contains(x + 1)) {
                    x++;                           // search for next no  
                    cnt++;
                }

                longest = Math.max(longest, cnt);  // finslly it take the max of cnt or previously updated longest  
            }
        }
        return longest;
    }
}