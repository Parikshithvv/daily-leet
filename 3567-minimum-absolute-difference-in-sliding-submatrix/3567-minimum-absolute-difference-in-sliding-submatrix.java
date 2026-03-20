class Solution {
    public int[][] minAbsDiff(int[][] matrix, int windowSize) {
        int rows = matrix.length, cols = matrix[0].length;
        int[][] result = new int[rows - windowSize + 1][cols - windowSize + 1];

        for (int startRow = 0; startRow <= rows - windowSize; startRow++) {
            for (int startCol = 0; startCol <= cols - windowSize; startCol++) {
                List<Integer> elements = new ArrayList<>();

                for (int r = startRow; r < startRow + windowSize; r++) {
                    for (int c = startCol; c < startCol + windowSize; c++) {
                        elements.add(matrix[r][c]);
                    }
                }

                Collections.sort(elements);

                int minDiff = Integer.MAX_VALUE;
                int previousValue = elements.get(0);

                for (int idx = 1; idx < elements.size(); idx++) {
                    int currentValue = elements.get(idx);

                    if (currentValue != previousValue) {
                        minDiff = Math.min(minDiff, currentValue - previousValue);
                    }

                    previousValue = currentValue;
                }

                result[startRow][startCol] = (minDiff == Integer.MAX_VALUE) ? 0 : minDiff;
            }
        }
        return result;
    }
}