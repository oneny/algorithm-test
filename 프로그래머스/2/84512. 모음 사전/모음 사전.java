class Solution {
    
    String[] alphabets = {"A", "E", "I", "O", "U"};
    int answer = 0;
    boolean checked = false;
    
    public int solution(String word) {
        
        for (int i = 0; i < alphabets.length; i++) {
            dfs(alphabets[i], word, 1);
            
            if (checked) break;
        }
        
        return answer;
    }
    
    private void dfs(String alpha, String word, int depth) {
        answer++;
        
        if (alpha.equals(word)) {
            checked = true;
            return;
        }
        
        if (depth == 5) {
            return;
        }
        
        for (int i = 0; i < alphabets.length; i++) {
            if (!checked) {
                dfs(alpha + alphabets[i], word, depth + 1);
            }
        }
    }
}