class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 2 * n - 1; i >= 0; i--) {
            int idx = i % n;
            int curr = nums[idx];

            while (!st.isEmpty() && st.peek() <= curr) {
                st.pop();
            }

            if (i < n) {
                ans[idx] = st.isEmpty() ? -1 : st.peek();
            }

            st.push(curr);
        }

        return ans;
    }
}
