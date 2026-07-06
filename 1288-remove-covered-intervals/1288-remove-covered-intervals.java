class Solution {
    public int removeCoveredIntervals(int[][] intervals) {

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return b[1] - a[1];
                } else {
                    return a[0] - b[0]; 
                }
            }
        });
        int count = 0;
        int maxEnd = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][1] > maxEnd) {
                count++;
                maxEnd = intervals[i][1];
            }
        }
        return count;
    }
}