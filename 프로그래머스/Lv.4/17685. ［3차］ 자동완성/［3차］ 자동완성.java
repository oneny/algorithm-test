import java.util.*;

class Solution {
    
    Node root = new Node();
    
    public int solution(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int answer = 0;
        boolean isCompleted = true;
        
        for (String word : words) {
            insert(word);
        }    
        
        return search(root, 0);
    }
    
    private int search(Node root, int count) {
        if (root.childCount == 1) {
            return count;
        }
        
        int cnt = 0;
        for (char key : root.childNodes.keySet()) {
            if (key == '-') {
                cnt += count;
            } else {
                cnt += search(root.childNodes.get(key), count + 1);
            }
        }
        
        return cnt;
    }
    
    
    private void insert(String word) {
        Node curNode = root;
        
        for (char c : word.toCharArray()) {
            Node newRoot = curNode.put(c);
            curNode = newRoot;
        }
        
        curNode.put('-');
    }
    
    static class Node {
        private HashMap<Character, Node> childNodes = new HashMap<>();
        private int childCount = 0;
        
        Node put(char c) {
            childCount++;
            
            if (!childNodes.containsKey(c)) {
                childNodes.put(c, new Node());
            }
            
            return childNodes.get(c);
        }
    }
}