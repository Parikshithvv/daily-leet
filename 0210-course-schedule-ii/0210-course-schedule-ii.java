import java.util.*;

class Solution {

    private boolean dfs(int node, List<List<Integer>> adj, int[] vis, int[] pathVis, Stack<Integer> st) {
        vis[node] = 1;
        pathVis[node] = 1;

        for (int it : adj.get(node)) {
            if (vis[it] == 0) {
                if (dfs(it, adj, vis, pathVis, st)) return true;
            } else if (pathVis[it] == 1) {
                return true;
            }
        }

        pathVis[node] = 0;
        st.push(node);
        return false;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]); // edge
        }

        int[] vis = new int[numCourses];
        int[] pathVis = new int[numCourses];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < numCourses; i++) {
            if (vis[i] == 0) {
                if (dfs(i, adj, vis, pathVis, st)) {
                    return new int[0]; // cycle → not possible
                }
            }
        }

        int[] ans = new int[numCourses];
        int i = 0;

        while (!st.isEmpty()) {
            ans[i++] = st.pop();
        }

        return ans;
    }
}