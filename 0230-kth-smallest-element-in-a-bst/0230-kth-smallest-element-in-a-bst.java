class Solution {

    private int count;
    private int answer;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inorder(root);
        return answer;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);
        if (--count == 0) {
            answer = node.val;
            return;
        }
        inorder(node.right);
    }

    public int kthLargest(TreeNode root, int k) {
        count = k;
        reverseInorder(root);
        return answer;
    }

    private void reverseInorder(TreeNode node) {
        if (node == null) return;

        reverseInorder(node.right);
        if (--count == 0) {
            answer = node.val;
            return;
        }
        reverseInorder(node.left);
    }
}
