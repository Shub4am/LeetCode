class TrieNode{
    public boolean isWord;
    public TrieNode[] node = new TrieNode[26];
    public TrieNode(){}
}
class Trie {
    private TrieNode root;
    

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode n = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(n.node[c - 'a'] == null) {
                n.node[c - 'a'] = new TrieNode();
            }
            n = n.node[c - 'a'];
        }
        n.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode n = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(n.node[c- 'a'] == null) 
                return false;
            n = n.node[c - 'a'];
        }
        return n.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode n = root;
        for(int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(n.node[c - 'a'] == null)
                return false;
            n = n.node[c - 'a'];
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