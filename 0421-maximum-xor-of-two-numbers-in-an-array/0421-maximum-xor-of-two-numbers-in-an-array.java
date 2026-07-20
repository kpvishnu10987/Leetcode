class TrieNode{
    TrieNode child[];
    TrieNode(){
        child = new TrieNode[2];
    }
}
class Trie{
    TrieNode root;
    public Trie(){
        root = new TrieNode();
    }
    public void insert(int num){
        TrieNode cur = root;
        for(int i = 31 ; i>=0 ; i--){
            int bit = (num >> i) & 1;

            if(cur.child[bit] == null){
                cur.child[bit] = new TrieNode();
            }

            cur = cur.child[bit];
        }
    }

    public int getmax(int num){
        TrieNode cur = root;
        int ans = 0;
        for(int i = 31 ; i>=0 ; i--){
            int bit = (num >> i) & 1;
            int op = 1-bit;

            if(cur.child[op] != null){
                ans |= (1<<i);
                cur = cur.child[op];
            }else{
                cur = cur.child[bit];
            }
        }
        return ans;
    }

}
class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie t = new Trie();

        for(int num : nums){
            t.insert(num);
        }

        int max = 0;

        for(int num : nums){
            max = Math.max(max,t.getmax(num));
        }

        return max;

    }
}