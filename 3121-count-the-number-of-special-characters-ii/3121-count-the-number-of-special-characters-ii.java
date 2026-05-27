class Solution {
    public int numberOfSpecialChars(String word) {
        int res = 0;
        
        for (char c = 'a'; c <= 'z'; c++) {
            int lower = word.lastIndexOf(c);
            int upper = word.indexOf(Character.toUpperCase(c));
            
            if (lower != -1 && upper != -1 && lower < upper) {
                res++;
            }
        }
        
        return res;
    }
}