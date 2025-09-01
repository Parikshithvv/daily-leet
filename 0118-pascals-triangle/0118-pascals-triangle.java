import java.util.*;

class Solution {
    public List<List<Integer>> generate(int row) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int r = 1; r <= row; r++) {
            long ansVal = 1;
            ArrayList<Integer> ansrow = new ArrayList<Integer>();
            ansrow.add(1);

            for (int col = 1; col < r; col++) {
                ansVal = ansVal * (r - col);
                ansVal = ansVal / col;
                ansrow.add((int) ansVal);
            }

            ans.add(ansrow);
        }

        return ans;
    }
}