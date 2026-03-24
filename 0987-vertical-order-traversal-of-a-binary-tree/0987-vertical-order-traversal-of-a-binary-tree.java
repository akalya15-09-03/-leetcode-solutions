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
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> list = new ArrayList<>();
        Queue<Object[]> q = new LinkedList<>();
        q.offer(new Object[]{root, 0, 0});
        while (!q.isEmpty()) {
            Object[] arr = q.poll();
            TreeNode node = (TreeNode) arr[0];
            int row = (int) arr[1];
            int col = (int) arr[2];
            list.add(new int[]{col, row, node.val});
            if (node.left != null) {
                q.offer(new Object[]{node.left, row + 1, col - 1});
            }
            if (node.right != null) {
                q.offer(new Object[]{node.right, row + 1, col + 1});
            }
        }
        Collections.sort(list, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            if (a[1] != b[1]) return a[1] - b[1];
            return a[2] - b[2];
        });
        List<List<Integer>> result = new ArrayList<>();
        int prevCol = Integer.MIN_VALUE;
        for (int[] node : list) {
            if (node[0] != prevCol) {
                result.add(new ArrayList<>());
                prevCol = node[0];
            }
            result.get(result.size() - 1).add(node[2]);
        }
        return result;
    }
}
