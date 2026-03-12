import java.util.*;

class Solution {
    public int calPoints(String[] operations) {

        Stack<Integer> st = new Stack<>();

        for (String s : operations) {

            if (s.equals("C")) {
                st.pop();
            }

            else if (s.equals("D")) {
                st.push(2 * st.peek());
            }

            else if (s.equals("+")) {
                int first = st.pop();
                int second = st.peek();
                int sum = first + second;

                st.push(first);
                st.push(sum);
            }

            else {
                st.push(Integer.valueOf(s));
            }
        }

        int result = 0;

        for (int i : st) {
            result += i;
        }

        return result;
    }
}