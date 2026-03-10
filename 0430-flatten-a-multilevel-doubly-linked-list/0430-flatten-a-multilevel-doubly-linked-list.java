/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head==null){
            return head;
        }

        Node curr = head;

        while(curr != null){
            Node next = curr.next;

            if(curr.child != null){
                curr.next = flatten(curr.child);
                curr.next.prev = curr;
                curr.child = null;

                while(curr.next != null){
                    curr = curr.next;
                }

                if(next != null){
                    curr.next = next;
                    next.prev = curr;
                }
            }

            curr = curr.next;
        }

        return head;
    }
}