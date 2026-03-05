class Solution {
    public int minOperations(String s) {
        int cnt1 = 0;
        int cnt2 = 0;
        int n = s.length();
        for(int i = 0; i < n; i++){
            char expected1;
            char expected2;
            if(i % 2 == 0){
                expected1 = '0';
            }else{
                expected1 = '1';
            }

            if(s.charAt(i) != expected1){
                cnt1++;
            }
            if(i % 2 == 0){
                expected2 = '1';
            }else{
                expected2 = '0';
            }

            if(s.charAt(i) != expected2){
                cnt2++;
            }
        }

        return Math.min(cnt1, cnt2);
    }
}