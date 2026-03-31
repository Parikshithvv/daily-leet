class Solution {
    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int sindex = 0;
        int cindex = 0;

        while(sindex<g.length && cindex < s.length){
            if(s[cindex] >= g[sindex]){
                sindex ++;
            }
            cindex++;
        }
        return sindex;
        
    }
}