import java.util.*;

class Solution {
    
    int count = 0;
    int answer = Integer.MAX_VALUE;
    boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        List<String> arrList = Arrays.asList(words);
        if (!arrList.contains(target)) return 0;
        visited = new boolean[words.length];
        
        dfs(begin, target, words);
        
        return answer;
    }
    
    public void dfs(String begin, String target, String[] words) {
        if (begin.equals(target) && count < answer) {
            answer = count;
            return;
        }
        
        for (int i = 0; i < words.length; i++) {
            if (visited[i]) continue;
            
            int sameCount = 0;
            for (int k = 0; k < target.length(); k++) {
                if (words[i].charAt(k) == begin.charAt(k)) sameCount++;
            }
            
            if (begin.length() - 1 == sameCount) {
                visited[i] = true;
                count++;
                dfs(words[i], target, words);
                visited[i] = false;
                count--;
            }
        }
    }
}