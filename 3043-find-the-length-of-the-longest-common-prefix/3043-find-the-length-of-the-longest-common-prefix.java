class Solution {
    public int digits(int x) {
        int cnt = 0;
        while (x > 0) {
            cnt++;
            x /= 10;
        }
        return cnt;
    }
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> prefixes = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            int x = arr1[i];
            while (x > 0) {
                prefixes.add(x);
                x /= 10;
            }
        }
        int ans = 0;
        for (int i = 0; i < arr2.length; i++) {

            int num = arr2[i];
            int x = num;
            int len = digits(num);
            while (x > 0) {
                if (prefixes.contains(x)) {
                    ans = Math.max(ans, len);
                    break;
                }
                x /= 10;
                len--;
            }
        }
        return ans;
    }
}