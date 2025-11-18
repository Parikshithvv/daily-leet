class Solution {
    public String removeKdigits(String num, int k) {

        Stack<Character> st = new Stack<>();

        for (char digit : num.toCharArray()) {

      
            while (!st.isEmpty() && k > 0 && st.peek() > digit) {
                st.pop();
                k--;
            }

            st.push(digit);
        }

        while (k > 0) {
            st.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : st) sb.append(c);

        int i = 0;
        while (i < sb.length() && sb.charAt(i) == '0') i++;

        String result = sb.substring(i);

        return result.isEmpty() ? "0" : result;
    }
}
