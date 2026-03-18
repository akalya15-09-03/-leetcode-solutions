import java.util.*;

class Solution {

    public void backtrack(TreeNode root, List<Integer> res, int level) {
        if (root == null) return;

        if (res.size() == level) {
            res.add(root.val);
        }
        backtrack(root.right, res, level + 1);
        backtrack(root.left, res, level + 1);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        backtrack(root, res, 0);
        return res;
    }
}