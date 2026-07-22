import java.util.*;
import java.util.regex.*;

class Solution {
    private int[] blockStarts, blockEnds, valleyValues;
    private int blockCount;
    private List<int[]> sparseTable;

    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        int totalOnes = (int) s.chars().filter(c -> c == '1').count();

        List<Integer> startsList = new ArrayList<>(), endsList = new ArrayList<>();
        Matcher matcher = Pattern.compile("0+").matcher(s);
        while (matcher.find()) { 
            startsList.add(matcher.start()); 
            endsList.add(matcher.end() - 1); 
        }
        
        blockStarts = startsList.stream().mapToInt(Integer::intValue).toArray();
        blockEnds = endsList.stream().mapToInt(Integer::intValue).toArray();
        blockCount = blockStarts.length;

        valleyValues = new int[Math.max(0, blockCount - 1)];
        for (int i = 0; i < blockCount - 1; i++) {
            valleyValues[i] = (blockEnds[i] - blockStarts[i] + 1) + (blockEnds[i + 1] - blockStarts[i + 1] + 1);
        }

        int numValleys = valleyValues.length;
        sparseTable = new ArrayList<>();
        sparseTable.add(valleyValues);
        for (int step = 1; step * 2 <= numValleys; step *= 2) {
            int[] previousLevel = sparseTable.get(sparseTable.size() - 1);
            int[] nextLevel = new int[previousLevel.length - step];
            for (int i = 0; i < nextLevel.length; i++) {
                nextLevel[i] = Math.max(previousLevel[i], previousLevel[i + step]);
            }
            sparseTable.add(nextLevel);
        }

        List<Integer> result = new ArrayList<>(queries.length);
        for (int[] query : queries) {
            result.add(totalOnes + calculateGain(query[0], query[1]));
        }
        return result;
    }

    private int rangeMaxQuery(int low, int high) {
        int power = 31 - Integer.numberOfLeadingZeros(high - low + 1);
        return Math.max(sparseTable.get(power)[low], sparseTable.get(power)[high - (1 << power) + 1]);
    }

    private int calculateClippedValue(int valleyIdx, int left, int right) {
        return valleyValues[valleyIdx] - Math.max(0, left - blockStarts[valleyIdx]) - Math.max(0, blockEnds[valleyIdx + 1] - right);
    }

    private int calculateGain(int left, int right) {
        if (blockCount < 2) return 0;
        int firstIdx = findLowerBound(blockEnds, left);
        int lastIdx = findUpperBound(blockStarts, right) - 2;
        
        if (firstIdx > lastIdx) return 0;
        
        int maxEdgeGain = Math.max(calculateClippedValue(firstIdx, left, right), calculateClippedValue(lastIdx, left, right));
        int maxMiddleGain = (lastIdx - firstIdx >= 2) ? rangeMaxQuery(firstIdx + 1, lastIdx - 1) : 0;
        
        return Math.max(maxEdgeGain, maxMiddleGain);
    }

    private static int findLowerBound(int[] array, int target) {
        int low = 0, high = array.length;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (array[mid] < target) low = mid + 1;
            else high = mid;
        }
        return low;
    }

    private static int findUpperBound(int[] array, int target) {
        int low = 0, high = array.length;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (array[mid] <= target) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}