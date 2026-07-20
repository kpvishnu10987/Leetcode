class TrieNode{
    TrieNode child[];
    boolean isend;
    TrieNode(){
        child = new TrieNode[26];
        isend = false;
    }
}

class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode cur = root;

        for(char ch : word.toCharArray()){
            int idx = ch-'a';
            if(cur.child[idx] == null){
                cur.child[ch-'a'] = new TrieNode();
            }

            cur = cur.child[idx];
        }

        cur.isend = true;
    }
    
    public boolean search(String word) {
        TrieNode cur = root;
        for(char ch : word.toCharArray()){
            int idx = ch-'a';

            if(cur.child[idx] == null) return false;

            cur = cur.child[idx];
        }
        return cur.isend;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(char ch : prefix.toCharArray()){
            int idx = ch-'a';

            if(cur.child[idx] == null) return false;

            cur = cur.child[idx];
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */