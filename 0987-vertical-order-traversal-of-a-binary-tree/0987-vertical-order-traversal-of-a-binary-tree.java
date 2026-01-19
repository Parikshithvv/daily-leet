/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Tuple {
    TreeNode node;
    int row;
    int col;

    Tuple(TreeNode node, int row, int col) {
        this.node = node;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        // col -> row -> minHeap of values
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();

        q.offer(new Tuple(root, 0, 0));

        while (!q.isEmpty()) {
            Tuple t = q.poll();
            TreeNode node = t.node;
            int r = t.row;
            int c = t.col;

            map.putIfAbsent(c, new TreeMap<>());
            map.get(c).putIfAbsent(r, new PriorityQueue<>());
            map.get(c).get(r).offer(node.val);

            if (node.left != null)
                q.offer(new Tuple(node.left, r + 1, c - 1));
            if (node.right != null)
                q.offer(new Tuple(node.right, r + 1, c + 1));
        }

        List<List<Integer>> res = new ArrayList<>();

        for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {
            List<Integer> colList = new ArrayList<>();
            for (PriorityQueue<Integer> pq : rows.values()) {
                while (!pq.isEmpty()) {
                    colList.add(pq.poll());
                }
            }
            res.add(colList);
        }

        return res;
    }
}
