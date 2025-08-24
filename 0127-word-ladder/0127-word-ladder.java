class Node {
    String word;
    int steps;

    Node(String word, int steps) {
        this.word = word;
        this.steps = steps;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return 0;  // endWord must be in wordList

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(beginWord, 1));
        set.remove(beginWord);

        while (!q.isEmpty()) {
            Node node = q.poll();
            String word = node.word;
            int st = node.steps;

            if (word.equals(endWord)) return st;

            char[] arr = word.toCharArray();  
            for (int i = 0; i < arr.length; i++) {
                char original = arr[i];
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (ch == original) continue;

                    arr[i] = ch;
                    String newWord = new String(arr);

                    if (set.contains(newWord)) {
                        q.offer(new Node(newWord, st + 1));
                        set.remove(newWord);  
                    }
                }
                arr[i] = original; 
            }
        }
        return 0;
    }
}
