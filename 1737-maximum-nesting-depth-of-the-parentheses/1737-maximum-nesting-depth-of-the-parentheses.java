class Solution {
    public int maxDepth(String s) {
        int maxdepth = 0;
        int depth = 0;

        for(int i=0, n = s.length(); i<n; i++){
            char c = s.charAt(i);
            if(c == '('){
                depth++;
                if(depth > maxdepth){
                    maxdepth = depth;
                }
            }else if(c == ')'){
                if(depth > 0) depth--;
            }

        }
        return maxdepth;
        
    }
}