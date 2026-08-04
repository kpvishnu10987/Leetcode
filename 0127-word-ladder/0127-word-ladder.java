class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);

        Queue<String> q = new LinkedList<>();

        if (!set.contains(endWord))
            return 0;

        q.offer(beginWord);
        int len = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            len++;
            while (size-- > 0) {
                String word = q.poll();
                char[] arr = word.toCharArray();

                for (int i = 0; i < arr.length; i++) {
                    char ori = arr[i];
                    for (int j = 'a'; j <= 'z'; j++) {
                        arr[i] = (char) j;
                        String newword = new String(arr);
                        if (newword.equals(endWord))
                            return len;
                        if (set.contains(newword)) {
                            set.remove(newword);
                            q.offer(newword);
                        }
                    }
                    arr[i] = ori;
                }
            }
        }

        return 0;
    }
}