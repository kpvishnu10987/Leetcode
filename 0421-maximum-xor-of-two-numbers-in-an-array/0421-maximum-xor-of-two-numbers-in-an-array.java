class Solution {
    class Trie{
        Trie[] child;
        Trie(){
            child = new Trie[2];
        }
    }

    Trie root = new Trie();

    void insert(int num){
        Trie node = root;
        for(int bit = 30 ; bit >=0 ;bit--){
            int b = (num >> bit) & 1;
            if(node.child[b] == null){
                node.child[b] = new Trie();
            }
                node = node.child[b];
            
        }
    }

    int getMax(int num){
        Trie node = root;
        int xor = 0;
        for(int bit = 30 ; bit >=0 ;bit--){
            int b = (num >> bit) & 1;
            int op = b ^ 1;

            if(node.child[op] != null){
                xor |= (1 << bit);
                node = node.child[op];
            }else{
                node = node.child[b];
            }
        }
        return xor;
    }
    public int findMaximumXOR(int[] nums) {
        for(int num :nums){
            insert(num);
        }
        int ans = 0;
        for(int num : nums){
            ans = Math.max(ans,getMax(num));
        }

        return ans;
    }
}