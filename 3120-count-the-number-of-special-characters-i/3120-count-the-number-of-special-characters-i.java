class Solution {
    public int numberOfSpecialChars(String word) {
        boolean[] seenLower = new boolean[26];
        boolean[] seenUpper = new boolean[26];
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                seenLower[ch - 'a'] = true;
            } else if (ch >= 'A' && ch <= 'Z') {
                seenUpper[ch - 'A'] = true;
            }
        }
        int specialCount = 0;
        for (int i = 0; i < 26; i++) {
            if (seenLower[i] && seenUpper[i]) {
                specialCount++;
            }
        }
        
        return specialCount;
    }
}