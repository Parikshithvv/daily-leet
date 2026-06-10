class Window {
    int L, R;
    long score;

    public Window(int L, int R, long score) {
        this.L = L;
        this.R = R;
        this.score = score;
    }
}

class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        SegmentTree tree = new SegmentTree(nums);
        PriorityQueue<Window> pq = new PriorityQueue<>((a, b) -> Long.compare(b.score, a.score));
        for (int i = 0; i < n; i++) {
            int[] res = tree.query(i, n - 1);
            long score = (long) res[1] - res[0];
            pq.add(new Window(i, n - 1, score));
        }

        long totalScore = 0;
        while (k-- > 0 && !pq.isEmpty()) {
            Window curr = pq.poll();
            totalScore += curr.score;
            
            int left = curr.L;
            int nextRight = curr.R - 1;
            if (left <= nextRight) {
                int[] res = tree.query(left, nextRight);
                long score = (long) res[1] - res[0];
                pq.add(new Window(left, nextRight, score));
            }
        }

        return totalScore;
    }
}

class SegmentTree {
    private Node root;

    public SegmentTree(int[] nums) {
        root = build(nums, 0, nums.length - 1);
    }

    public int[] query(int start, int end) {
        return queryRange(root, start, end);
    }   

    private int[] queryRange(Node node, int start, int end) {
        if (node == null) {
            return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE};
        }
        if (start <= node.s && node.e <= end) {
            return new int[]{node.min, node.max};
        }
        if (node.e < start || end < node.s) {
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        }
        
        int[] leftRes = queryRange(node.left, start, end);
        int[] rightRes = queryRange(node.right, start, end);
        
        return new int[]{
            Math.min(leftRes[0], rightRes[0]), 
            Math.max(leftRes[1], rightRes[1])
        };
    }

    private Node build(int[] nums, int start, int end) {
        Node node = new Node(start, end);
        if (start == end) {
            node.min = nums[start];
            node.max = nums[start];
            return node;
        }
        
        int mid = (start + end) / 2;
        node.left = build(nums, start, mid);
        node.right = build(nums, mid + 1, end);
        
        node.min = Math.min(node.left.min, node.right.min);
        node.max = Math.max(node.left.max, node.right.max);
        return node;
    }
    
    private static class Node {
        int s, e;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Node left, right;

        public Node(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
}