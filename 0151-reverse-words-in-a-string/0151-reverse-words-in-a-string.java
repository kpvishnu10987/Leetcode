class Solution {
    public String reverseWords(String s) {
        s = s.trim(); // remove leading & trailing spaces
        Stack<String> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                sb.append(c);
            } else if (sb.length() > 0) {
                // word complete → push and reset
                st.push(sb.toString());
                sb.setLength(0);
                // skip multiple spaces
                while (i + 1 < s.length() && s.charAt(i + 1) == ' ') i++;
            }
        }

        // push the last word
        if (sb.length() > 0) st.push(sb.toString());

        // build reversed result
        sb.setLength(0);
        while (!st.isEmpty()) {
            sb.append(st.pop());
            if (!st.isEmpty()) sb.append(' ');
        }

        return sb.toString();
    }
}
