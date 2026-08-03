class Solution {
    public int compress(char[] chars) {

        int read = 0;
        int write = 0;
        int n = chars.length;

        while (read < n) {

            char curr = chars[read];
            int start = read;

            while (read < n && chars[read] == curr) {
                read++;
            }

            int len = read - start;

            // Write the character
            chars[write++] = curr;

            // Write the count if greater than 1
            if (len > 1) {
                String cnt = String.valueOf(len);

                for (char c : cnt.toCharArray()) {
                    chars[write++] = c;
                }
            }
        }

        return write;
    }
}