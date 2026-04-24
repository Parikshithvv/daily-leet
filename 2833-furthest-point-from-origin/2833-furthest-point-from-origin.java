class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int lft=0;
        int rht=0;
        int blank = 0;

        for(char c : moves.toCharArray()){
            if(c == 'L') lft++;
            else if (c == 'R') rht++;
            else blank++;
        }
        return Math.abs(lft - rht) + blank;
        
    }
}