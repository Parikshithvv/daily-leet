class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));

        int initialEnergy = tasks[0][1];
        int curEnergy = tasks[0][1] - tasks[0][0];
        int extraNeeded = 0;

        for (int i = 1; i < tasks.length; i++) {
            int actualCost = tasks[i][0];
            int minRequired = tasks[i][1];

            if (curEnergy < minRequired) {
                extraNeeded += minRequired - curEnergy;
                curEnergy = minRequired;
            }
            curEnergy -= actualCost;
        }

        return initialEnergy + extraNeeded;
    }
}