class Solution {
    public char findKthBit(int n, int k) {
        if(n==1) return '0';
        String s[] = new String[n];
        s[0] = "0";
        for(int i=1; i<n; i++) {
            s[i] = s[i-1] + "1" + reverse(inverse(s[i-1]));
        }
        String res = s[n-1];
        return res.charAt(k-1);
    }

    public String inverse(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            sb.append(c == '0' ? "1" : "0");
        }
        return sb.toString();
    }

    public String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
}