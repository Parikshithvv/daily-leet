class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=1;i<=numRows;i++){
            long ansval = 1;
            ArrayList<Integer> ansrow = new ArrayList<>();
            ansrow.add(1);

            for(int col = 1; col<i;col++){
                ansval = ansval * (i-col);
                ansval = ansval / col;
                ansrow.add((int) ansval);
            
            }
             ans.add(ansrow);
        }
        return ans;

       

        
    }
}