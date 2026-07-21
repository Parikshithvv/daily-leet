class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int totalOnes = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                totalOnes++;
            }
        }

        s = "1" + s + "1";

        int length = s.length();
        int idx = 0;

        int maxActive = totalOnes;

        while (idx < length && s.charAt(idx) == '1') {
            idx++;
        }

        int leftZeros = 0;
        while (idx < length && s.charAt(idx) == '0') {
            leftZeros++;
            idx++;
        }

        while (idx < length) {
            int middleOnes = 0;
            while (idx < length && s.charAt(idx) == '1') {
                middleOnes++;
                idx++;
            }

            if (middleOnes == 0) {
                break;
            }

            int rightZeros = 0;
            while (idx < length && s.charAt(idx) == '0') {
                rightZeros++;
                idx++;
            }

            if (rightZeros == 0) {
                break;
            }

            maxActive = Math.max(maxActive, totalOnes + leftZeros + rightZeros);
            leftZeros = rightZeros;
        }

        return maxActive;
    }
}