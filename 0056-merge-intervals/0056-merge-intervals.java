
// i wanna fkin revise this 100000 times

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][0];

        // ✅ Sort intervals by start value
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> result = new ArrayList<>();

        // Take the first interval as starting point
        int start = intervals[0][0];
        int end = intervals[0][1];

        // Traverse remaining intervals
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end) {
                // Overlap → extend the end
                end = Math.max(end, intervals[i][1]);
            } else {
                // No overlap → save the previous interval
                result.add(new int[]{start, end});
                // Move to the new interval
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        // Add the last interval
        result.add(new int[]{start, end});

        // Convert list to array
        return result.toArray(new int[result.size()][]);
    }
}