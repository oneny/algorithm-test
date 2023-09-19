class TrieNode {
    private boolean isEnd;
    private TrieNode[] children;
    
    public TrieNode() {
        isEnd = false;
        children = new TrieNode[26];
        
        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }
    }
    
    public boolean isLast() {
        return isEnd;
    }
    
    private boolean isThereChild(char c) {
        return (children[c - 'a'] != null);
    }
    
    public TrieNode getChild(char c) {
        if (isThereChild(c)) return children[c - 'a'];
        return null;
    }
    
    public void addChild(char c) {
        if (isThereChild(c)) return;
        
        children[c - 'a'] = new TrieNode();
    }
    
    public void setIsEnd() {
        isEnd = true;
    }
}

class Trie {
    
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode current = root;
        
        for (char c : word.toCharArray()) {
            current.addChild(c);
            
            current = current.getChild(c);
        }
        
        current.setIsEnd(); // 마지막에 isEnd 설정
    }
    
    public boolean search(String word) {
        TrieNode lastNode = traverseTrieAndGetLastNode(word);
        
        return (lastNode == null) ? false : lastNode.isLast();
    }
    
    public boolean startsWith(String prefix) {
        return traverseTrieAndGetLastNode(prefix) != null;
    }
    
    public TrieNode traverseTrieAndGetLastNode(String word) {
        TrieNode current = root;
        
        for (char c : word.toCharArray()) {
            if (current.getChild(c) == null) return null;
            
            current = current.getChild(c);
        }
        
        return current;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */