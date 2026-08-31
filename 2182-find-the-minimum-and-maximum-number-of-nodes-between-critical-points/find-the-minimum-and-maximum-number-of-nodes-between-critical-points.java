/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return new int[]{-1, -1};

        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = curr.next;

        int idx = 2; // curr is at position 2
        int first = -1, last = -1, prevCrit = -1;
        int minDist = Integer.MAX_VALUE;

        while (next != null) {
            boolean isMax = (curr.val > prev.val && curr.val > next.val);
            boolean isMin = (curr.val < prev.val && curr.val < next.val);
            if (isMax || isMin) {
                if (first == -1) first = idx;
                if (prevCrit != -1) {
                    minDist = Math.min(minDist, idx - prevCrit);
                }
                prevCrit = idx;
                last = idx;
            }

            // advance
            prev = curr;
            curr = next;
            next = next.next;
            idx++;
        }

        if (first == -1 || first == last) return new int[]{-1, -1};
        return new int[]{minDist, last - first};
    }
}