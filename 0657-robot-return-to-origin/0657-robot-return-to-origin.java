class Solution {
    public boolean judgeCircle(String moves) {
        int U = 0,D=0,l=0,r=0;
        int n = moves.length();
        for(int i=0;i<n;i++){
            char c = moves.charAt(i);
            if(c == 'U'){
                U++;
            }else if( c == 'D'){
                U--;
            }

            if(c == 'L'){
                l++;
            }else if(c == 'R'){
                l--;
            }
        }
        return (U == 0 && l == 0);

        
    }
}