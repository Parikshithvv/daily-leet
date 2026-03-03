class Solution {
    public char findKthBit(int n, int k) {
        if (n == 1) return '0';
        
        int length = (1 << n) - 1;
        int midd = (length + 1) / 2;
        
        if (k == midd) return '1';
        if (k < midd) return findKthBit(n - 1, k);
        
        char c = findKthBit(n - 1, length - k + 1);
        return c == '0' ? '1' : '0';
    }
}