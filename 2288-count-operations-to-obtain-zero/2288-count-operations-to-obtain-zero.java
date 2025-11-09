class Solution {
    public int countOperations(int a, int b) {
        int c = 0;
        while (a > 0 && b > 0) {
            if (a >= b) {
                c += a / b;
                a %= b;
            } else {
                c += b / a;
                b %= a;
            }
        }
        return c;
    }
}
