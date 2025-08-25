class Node{
    String word;
    int steps;
    Node(String word,int steps){
        this.word = word;
        this.steps = steps;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordset = new HashSet<>(wordList);
        if(!wordset.contains(endWord)) return 0;

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(beginWord,1));
        wordset.remove(beginWord);

        while(!q.isEmpty()){
            String w = q.peek().word;
            int st = q.peek().steps;
            q.poll();
            if(w.equals(endWord)) return st;


            char[] arr = w.toCharArray();
            for(int i = 0 ; i<arr.length; i++){
                char original = arr[i];
                for(char c= 'a' ; c <= 'z' ; c++){
                    if(c == original) continue;

                    arr[i] = c;
                    String temp = new String(arr);
                    if(wordset.contains(temp)){
                        q.offer(new Node(temp,st+1));
                        wordset.remove(temp);
                    }
                }
                arr[i] = original;
            }
        }

        return 0;
    }
}