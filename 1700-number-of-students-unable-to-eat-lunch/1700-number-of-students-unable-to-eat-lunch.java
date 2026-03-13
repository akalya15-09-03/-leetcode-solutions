import java.util.*;

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {

        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> st = new Stack<>();

        for (int s : students) {
            q.offer(s);
        }

        for (int i = sandwiches.length - 1; i >= 0; i--) {
            st.push(sandwiches[i]);
        }

        int count = 0;

        while (!q.isEmpty() && count < q.size()) {

            if (q.peek().equals(st.peek())) {
                q.poll();
                st.pop();
                count = 0;
            } else {
                q.offer(q.poll());
                count++;
            }
        }

        return q.size();
    }
}