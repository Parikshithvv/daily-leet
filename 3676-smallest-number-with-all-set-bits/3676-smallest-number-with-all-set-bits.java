class Solution {
    public int smallestNumber(int n) {
         int bitLen = Integer.SIZE - Integer.numberOfLeadingZeros(n);
        return (1<<bitLen)-1;        
    }
}