import java.util.*;

class Solution {
    public int minimumDistance(int[] arr) {
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            indexMap.computeIfAbsent(arr[i], key -> new ArrayList<>()).add(i);
        }
        int minDistance = Integer.MAX_VALUE;  
        for (List<Integer> indices : indexMap.values()) {
            if (indices.size() < 3) continue;
            for (int i = 0; i <= indices.size() - 3; i++) {
                int firstIndex = indices.get(i);
                int thirdIndex = indices.get(i + 2);

                int distance = 2 * (thirdIndex - firstIndex);
                minDistance = Math.min(minDistance, distance);
            }
        }
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }
}