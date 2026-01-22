class Solution {

    public int findMinAdjacentPairIndex(List<Integer> v) {
        int minSum = (int) 1e9;
        int pos = -1;

        for (int i = 0; i < v.size() - 1; i++) {
            int sum = v.get(i) + v.get(i + 1);
            if (sum < minSum) {
                minSum = sum;
                pos = i;
            }
        }
        return pos;
    }

    public void mergeAdjacentPair(List<Integer> v, int pos) {
        v.set(pos, v.get(pos) + v.get(pos + 1));
        v.remove(pos + 1);
    }
    public int minimumPairRemoval(int[] nums) {
        List<Integer> v = new ArrayList<>();
        for (int x : nums) v.add(x);

        int ops = 0;
        while (!isNonDecreasing(v)) {
            int pos = findMinAdjacentPairIndex(v);
            mergeAdjacentPair(v, pos);
            ops++;
        }
        return ops;
    }

    private boolean isNonDecreasing(List<Integer> v) {
        for (int i = 0; i < v.size() - 1; i++) {
            if (v.get(i) > v.get(i + 1)) return false;
        }
        return true;
    }
}
