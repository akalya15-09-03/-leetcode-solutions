class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder();
        int len = part.length();
        for (char c : s.toCharArray()) {
            sb.append(c);
            if (sb.length() >= len &&
                sb.substring(sb.length() - len).equals(part)) {
                sb.delete(sb.length() - len, sb.length());
            }
        }
        return sb.toString();
    }
}