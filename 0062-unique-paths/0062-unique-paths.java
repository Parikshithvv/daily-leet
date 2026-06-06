class Solution {
    public int uniquePaths(int m, int n) {
        long ans = 1;
        int totalMoves = m + n - 2;
        int downMoves = Math.min(m - 1, n - 1); 
        for (int i = 1; i <= downMoves; i++) {
            ans = ans * (totalMoves - downMoves + i) / i;
        }
        return (int) ans;
    }
}