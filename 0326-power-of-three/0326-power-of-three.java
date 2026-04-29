class Solution {
    public boolean isPowerOfThree(int n) {
        
        if(n == 0) return false;

        while(n>0){
            if(n==1) return true;
            if(n%3 != 0) break;
            n = n/3;
        }

        return false;
        
    }
}