class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int index = 0; 
        int i = 0;    

        while (i < n) {
            char current = chars[i];
            int count = 0;
            while (i < n && chars[i] == current) {
                i++;
                count++;
            }
            chars[index++] = current;
            if (count > 1) {
                String cnt = String.valueOf(count);
                for (char c : cnt.toCharArray()) {
                    chars[index++] = c;
                }
            }
        }

        return index;
    }
}