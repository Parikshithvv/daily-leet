class Solution {
    private int[] depth;
    private int[][] up;
    private int LOG;
    private final int MOD = 1_000_000_007;
    private int power(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return (int) res;
    }
    private int countWays(int d) {
        if (d == 0) return 0;
        return power(2, d - 1);
    }
    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        int n = edges.length + 1;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        LOG = 0;
        while ((1 << LOG) <= n) {
            LOG++;
        }
        depth = new int[n + 1];
        up = new int[n + 1][LOG];
        bfs(1, adj);
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = countWays(getDistance(queries[i][0], queries[i][1]));
        }

        return ans;
    }
    private void bfs(int root, List<List<Integer>> adj) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);
        depth[root] = 0;
        Arrays.fill(up[root], root);
        boolean[] visited = new boolean[adj.size()];
        visited[root] = true;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int nxt : adj.get(curr)) {
                if (!visited[nxt]) {
                    visited[nxt] = true;
                    depth[nxt] = depth[curr] + 1;
                    up[nxt][0] = curr;
                    for (int j = 1; j < LOG; j++) {
                        up[nxt][j] = up[up[nxt][j - 1]][j - 1];
                    }
                    queue.add(nxt);
                }
            }
        }
    }
    private int getDistance(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }
        int dist = 0;
        int diff = depth[u] - depth[v];
        dist += diff;
        for (int i = LOG - 1; i >= 0; i--) {
            if (((diff >> i) & 1) == 1) {
                u = up[u][i];
            }
        }
        if (u == v) return dist;
        for (int i = LOG - 1; i >= 0; i--) {
            if (up[u][i] != up[v][i]) {
                u = up[u][i];
                v = up[v][i];
                dist += (1 << (i + 1));
            }
        }
        dist += 2;
        return dist;
    }
}