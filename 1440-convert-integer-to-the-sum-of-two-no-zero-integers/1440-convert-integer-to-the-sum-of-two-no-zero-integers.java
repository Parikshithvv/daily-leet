class Solution {
    public int[] getNoZeroIntegers(int n) {
        int no = 1;
        for (int i = n - 1; i >= 0; i--) {
            int sum = i + no;
            String a = String.valueOf(no);
            String b = String.valueOf(i);

            if (a.contains("0") || b.contains("0")) {
                no++;
                continue;
            }
            return new int[]{no, i};
        }
        return new int[]{};
    }
}