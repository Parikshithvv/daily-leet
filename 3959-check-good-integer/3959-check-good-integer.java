class Solution {
    public boolean checkGoodInteger(int n) {
        int sum1 = 0,sum2 = 0;
        while(n>0){
            int dig = n%10;
            sum1 = sum1+dig;
            sum2 = sum2 + (dig*dig);
            n = n/10;

        }
        return sum2-sum1>=50;


        
    }
}