class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();

        while (n != 1 && !visited.contains(n)) {
            visited.add(n);
            int nextN = 0;
            while (n > 0) {
                int digit = n % 10;
                nextN += digit * digit;
                n /= 10;
            }
            n = nextN;
        }

        return n == 1;
    }
}
