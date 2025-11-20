class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int[] ans = new int[n - k + 1];
        int idx = 0;

        for (int i = 0; i < n; i++) {
           
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }

            dq.addLast(i);

            if (i >= k - 1) {
                ans[idx++] = nums[dq.peekFirst()];
            }
        }

        return ans;
    }
}
//  size theek kro
//  maximum dq.front() par a ajae
//  usko push kr do
// push nums[dq.front()] in ur ans
//   we r stroing index not values